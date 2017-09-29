package com.muguku.mash.nyumbani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    EditText ET_USER_NAME,ET_USER_MESS;
    String user_name,user_mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        ET_USER_NAME = (EditText)findViewById(R.id.uuname);
        ET_USER_MESS = (EditText)findViewById(R.id.iinput_password);



/*    public void regHostel(View view) {

        TextView signInButton = (TextView) findViewById(R.id.bbutonmbili);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(ChatActivity.this, AppartmentsNavigationActivity.class);
                startActivity(signUpIntent);
            }
        });
    }*/

    }

    public void messg(View view){

        user_name = ET_USER_NAME.getText().toString();
        user_mess = ET_USER_MESS.getText().toString();

        String method = "chat";
        ChatAdapter chatAdapter = new ChatAdapter(this);
        chatAdapter.execute(method,user_name,user_mess);



 /*       TextView signInButton = (TextView) findViewById(R.id.bbutonmbili);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUpIntent = new Intent(ChatActivity.this, LoginActivity.class);
                startActivity(signUpIntent);
            }
        });*/
    }

}
