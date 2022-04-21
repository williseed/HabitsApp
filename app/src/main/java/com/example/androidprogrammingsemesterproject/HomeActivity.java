package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    // declare the fragment
    HomeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // put the fragment in the container
        fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment);

        // a button to open fragment
        Button buttonRewards = (Button)findViewById(R.id.buttonRewards);
        buttonRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        }); // end buttonRewards

        // a button links to ProgressActivity.class // by intent
        Button buttonViewProgress = (Button)findViewById(R.id.buttonViewProgress);
        buttonViewProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProgressActivity.class);
                startActivity(intent);
            }
        }); // end buttonViewProgress

        // a button links to HabbitsActivity.class // by intent
        Button buttonModifyHabbits = (Button)findViewById(R.id.buttonModifyHabbits);
        buttonModifyHabbits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HabbitsActivity.class);
                startActivity(intent);
            }
        }); // end buttonModifyHabbits

    } // end onCreate(Bundle savedInstanceState)

    // ALL THE ACTION BAR CODE IS BELOW/////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_home:
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_logout:
                LoginActivity.loggedIn = false;
                Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //////////////////////////////////////////////////////////////////////////////

} // end HomeActivity