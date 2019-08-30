package com.skipzen.test82519_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final EditText etUsername = (EditText) findViewById(R.id.username);
        final EditText etEmail = (EditText) findViewById(R.id.email);
        final TextView Wlcomemessage = (TextView) findViewById(R.id.mymassage);

        Intent intent = getIntent();
        String fullname = intent.getStringExtra("fullname");
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        String message = fullname + " Welcome to our aplication";
        Wlcomemessage.setText(message);
        etUsername.setText(username);
        etEmail.setText(email);
    }
}
