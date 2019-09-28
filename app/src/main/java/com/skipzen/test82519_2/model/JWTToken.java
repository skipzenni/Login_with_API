package com.skipzen.test82519_2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JWTToken {
    @Expose
    @SerializedName("access_token")
    public String token;

    public JWTToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
