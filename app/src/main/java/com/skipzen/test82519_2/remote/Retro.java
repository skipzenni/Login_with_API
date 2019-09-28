package com.skipzen.test82519_2.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {
    private static final String BASE_URL="http://indiarkmedia.com" ;
    private static Retrofit getRetrofitInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static APICall getAPICall(){
        return getRetrofitInstance().create(APICall.class);
    }
}
