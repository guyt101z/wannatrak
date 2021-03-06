/*
 * Copyright 2009 Andrey Khalzov, and individual contributors as indicated by the @author tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

/**
 * Created by Andrey Khalzov
 * 16.03.2009
 */
package org.wannatrak.device;

import org.wannatrak.middleware.ejb.SubjectWorkerLocal;
import org.wannatrak.middleware.util.ServiceLocator;
import org.wannatrak.middleware.exception.EntityNotFoundException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final SubjectWorkerLocal subjectWorkerLocal = ServiceLocator.lookupLocal(SubjectWorkerLocal.JNDI_NAME);

        final String deviceId = request.getParameter("deviceId");

        try {
            subjectWorkerLocal.unlinkSubject(deviceId);
        } catch (EntityNotFoundException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
