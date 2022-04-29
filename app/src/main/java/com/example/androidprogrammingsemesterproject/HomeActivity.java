package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    // declare the fragment
    HomeFragment1 fragment1;
    HomeFragment2 fragment2;
    HomeFragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // put the fragment in the container
        fragment1 = new HomeFragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1);
        fragment2 = new HomeFragment2();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment2);
        fragment3 = new HomeFragment3();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment3);

        // a button to open fragment
        Button buttonInspiration = (Button)findViewById(R.id.buttonInspiration);
        buttonInspiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = new Random().nextInt(3) + 1; // random number 1 ~ 3

                // open a random fragment (1 ~ 3)
                if(random == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                }
                else if(random == 2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                }
            }
        }); // end buttonInspiration

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