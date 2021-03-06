/*
 * Copyright (C) 2013 Chris Lacy Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.appdotnet4j.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdnUsers {

    public ArrayList<AdnUser> mUsers;

    public AdnUsers(JSONArray jsonArray) {
        mUsers = new ArrayList<AdnUser>();

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                String listString = jsonArray.getString(i);
                AdnUser user = new AdnUser(listString);
                mUsers.add(user);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (mUsers.size() == 0) {
            mUsers = null;
        }
    }

    public AdnUsers(String jsonAsString) {
        mUsers = new ArrayList<AdnUser>();

        try {
            JSONArray jsonArray = new JSONObject(jsonAsString)
                    .getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                String listString = jsonArray.getString(i);
                AdnUser user = new AdnUser(listString);
                mUsers.add(user);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (mUsers.size() == 0) {
            mUsers = null;
        }
    }
}