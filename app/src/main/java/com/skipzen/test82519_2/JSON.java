package com.skipzen.test82519_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skipzen.test82519_2.model.JWTToken;
import com.skipzen.test82519_2.remote.APICall;
import com.skipzen.test82519_2.remote.Retro;
import com.skipzen.test82519_2.tokenmanager.TokenManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class JSON extends AppCompatActivity {

    Button btnLogin;
    EditText etlogin, etpassword;
    private TokenManager tokenManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        tokenManager = new TokenManager(getApplicationContext());
        etlogin = (EditText) findViewById(R.id.login);
        etpassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final APICall apiCall= Retro.getAPICall();
                final String login = etlogin.getText().toString();
                final String password = etpassword.getText().toString();

                retrofit2.Call<JWTToken> jwtTokenCall = apiCall.userLogin(login, password);

                jwtTokenCall.enqueue(new Callback<JWTToken>() {
                    @Override
                    public void onResponse(Call<JWTToken> call, Response<JWTToken> response) {
                        JWTToken jwtToken = response.body();
                        tokenManager.createseason(login, jwtToken.getToken().toString() );
                        Call<String> userCall = apiCall.getUser(jwtToken.getToken().toString());
                        userCall.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                response.body();
                                showtoast(""+response.body().toString());
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                showtoast(""+t.getMessage());
                            }
                        });
                        showtoast(""+jwtToken.getToken().toString());
                    }

                    @Override
                    public void onFailure(Call<JWTToken> call, Throwable t) {

                    }
                });
            }
        });
    }
    void showtoast(String msg){
        Toast.makeText(this, ""+ msg , Toast.LENGTH_LONG).show();
    }
}
