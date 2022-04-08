package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
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

    // action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

} // end HomeActivity