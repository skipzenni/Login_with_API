package com.skipzen.test82519_2.remote;

import com.skipzen.test82519_2.model.JWTToken;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APICall {
    @FormUrlEncoded
    @POST("/api/v2/authenticate")
    Call<JWTToken> userLogin(@Field("login") String login, @Field("password") String password);

    @GET("/api/v2/authenticate")
    Call<String> getUser(@Header("Authorization") String Authorization);
}
