package com.muguku.mash.nyumbani;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



/**
 * Created by mash on 7/19/17.
 */

public class RegisterActivity extends AppCompatActivity  {
    private static final String TAG = RegisterActivity.class.getSimpleName();

   /* private EditText fullname, email, password;*/
    EditText ET_EMAIL, ET_USER_NAME,ET_USER_PASS;
    String email,user_name,user_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ET_EMAIL = (EditText)findViewById(R.id.email);
        ET_USER_NAME = (EditText)findViewById(R.id.name);
        ET_USER_PASS = (EditText)findViewById(R.id.input_password);

/*
        Button linkToLogin = (Button)findViewById(R.id.link_to_login);
        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(homeIntent);
            }
        });

        Button signUpButton = (Button)findViewById(R.id.btnRegister);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set a toast or some message to say redirecting to login page
                Intent homeIntent = new Intent(RegisterActivity.this, RegisterActivity.class);
                startActivity(homeIntent);
            }
        });*/

    }



    public void userReg2(View view){

        email = ET_EMAIL.getText().toString();
        user_name = ET_USER_NAME.getText().toString();
        user_pass = ET_USER_PASS.getText().toString();

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,email,user_name,user_pass);



        TextView signInButton = (TextView) findViewById(R.id.butonmbili);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(signUpIntent);
            }
        });
    }

}
