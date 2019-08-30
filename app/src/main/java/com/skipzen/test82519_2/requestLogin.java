package com.skipzen.test82519_2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class requestLogin extends StringRequest {
    private static final String LOGIN_REQ_URL = "http://indiarkmedia.com/api/v2/participant";
    private Map<String, String> params;

    public requestLogin(String login,String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQ_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
        params.put("password", password);
    }
    public Map<String, String>getParams(){
        return params;
    }
}
