package com.muguku.mash.nyumbani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A login screen that offers login via email/password.
 */
public class PostNewActivity extends AppCompatActivity {

    EditText ET_HSTL_NAME,ET_HSTL_TYPE,ET_AVAILABLE_ROOMS, ET_HSTL_PRICE;
    String hstl_name,hstl_type,available_rooms, hstl_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_new);

        ET_HSTL_NAME = (EditText)findViewById(R.id.hstlname);
        ET_HSTL_TYPE = (EditText)findViewById(R.id.hstltype);
/*        ET_HSTL_LOCATION = (EditText)findViewById(R.id.hstllocation);*/
        ET_AVAILABLE_ROOMS = (EditText)findViewById(R.id.availablerooms);
        ET_HSTL_PRICE = (EditText)findViewById(R.id.roomprices);
}
    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(false);
    }

    public void regNewHostel(View view) {
        hstl_name = ET_HSTL_NAME.getText().toString();
        hstl_type = ET_HSTL_TYPE.getText().toString();
       /* hstl_location = ET_HSTL_LOCATION.getText().toString();*/
        available_rooms = ET_AVAILABLE_ROOMS.getText().toString();
        hstl_price = ET_HSTL_PRICE.getText().toString();


        String method = "newhstl";
        newHostelAdapter newHostelAdapter = new newHostelAdapter(this);
        newHostelAdapter.execute(method,hstl_name,hstl_type,available_rooms,hstl_price);

    }
}


