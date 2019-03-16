package com.muguku.mash.nyumbani;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by mash on 7/30/17.
 */


public class BaseActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                drawerLayout.closeDrawers();


                switch (menuItem.getItemId()) {

                    case R.id.nav_camera:
                        Toast.makeText(getApplicationContext(), "First fragment", Toast.LENGTH_SHORT).show();

                        Intent signInIntent = new Intent(BaseActivity.this, LoginActivity.class);
                        startActivity(signInIntent);
                    case R.id.nav_gallery:
                        Toast.makeText(getApplicationContext(), "Second fragment", Toast.LENGTH_SHORT).show();

                        Intent signInIntent2 = new Intent(BaseActivity.this, LoginActivity.class);
                        startActivity(signInIntent2);
                        return true;
                    case R.id.nav_slideshow:
                        Toast.makeText(getApplicationContext(), "Second fragment", Toast.LENGTH_SHORT).show();

                        Intent signInIntent3 = new Intent(BaseActivity.this, LoginActivity.class);
                        startActivity(signInIntent3);
                        return true;
                    case R.id.nav_manage:
                        Toast.makeText(getApplicationContext(), "Second fragment", Toast.LENGTH_SHORT).show();

                        Intent signInIntent4 = new Intent(BaseActivity.this, LoginActivity.class);
                        startActivity(signInIntent4);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });


        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }
}
