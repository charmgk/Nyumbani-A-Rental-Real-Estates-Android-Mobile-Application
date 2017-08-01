package com.muguku.mash.nyumbani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


/**
 * A login screen that offers login via email/password.
 */
public class PostNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }


    public void regHostel(View view) {

        TextView signInButton = (TextView) findViewById(R.id.butonmbili);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(PostNewActivity.this, AppartmentsNavigationActivity.class);
                startActivity(signUpIntent);
            }
        });
    }
}


