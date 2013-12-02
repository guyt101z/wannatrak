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

package org.wannatrak.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by Andrey Khalzov
 * 23.12.2008 18:55:53
 */
public interface LoginServiceAsync {

    void login(String login, String password, Boolean keepMyLogin, AsyncCallback<String> async);

    void logout(AsyncCallback async);

    void tryToLogin(AsyncCallback<String> asyncCallback);
}