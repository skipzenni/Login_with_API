package com.skipzen.test82519_2.tokenmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int mode = 0;
    private static final String REFNAME = "JWTTOKEN";
    private static final String KEY_USER_NAME = "username";
    private static final String KEY_JWT_TOKEN = "jwttoken";
    private Context context;

    public TokenManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(REFNAME, mode);
        editor = sharedPreferences.edit();
    }
    public void createseason(String login, String jwtvalue){
        editor.putString(KEY_USER_NAME, login);
        editor.putString(KEY_JWT_TOKEN, jwtvalue);
        editor.commit();
    }

}
