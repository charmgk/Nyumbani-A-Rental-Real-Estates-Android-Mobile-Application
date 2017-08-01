package com.muguku.mash.nyumbani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

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
                Intent signUpIntent = new Intent(ChatActivity.this, AppartmentsNavigationActivity.class);
                startActivity(signUpIntent);
            }
        });
    }
}
