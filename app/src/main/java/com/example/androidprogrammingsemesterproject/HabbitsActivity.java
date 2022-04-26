package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;

public class HabbitsActivity extends AppCompatActivity {
    Bundle extras = getIntent().getExtras();
    String currentString;
    String newHabbitName = extras.getString("HabbitObjectName");
    LinearLayout HealthLayout = findViewById(R.id.HealthLinearLayout);
    LinearLayout WorkLayout = findViewById(R.id.WorkLinearLayout);
    LinearLayout SchoolLayout = findViewById(R.id.SchoolLinearLayout);
    boolean chipReadyPrep = extras.getBoolean("chipReady");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbits);

        if (chipReadyPrep = true) {
            HabbitObject chippedHabit = new HabbitObject(newHabbitName);
            Chip chip = new Chip(this);
            chip.setText(chippedHabit.name);
            if(chippedHabit.type == "Work"){
                WorkLayout.addView(chip);
            }
            else if(chippedHabit.type == "School"){
                SchoolLayout.addView(chip);
            }
            else if(chippedHabit.type == "Health"){
                HealthLayout.addView(chip);
            }
            
        }

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                intent.putExtra("newHabbitBool", true);
                startActivity(intent);
            }
        });

        Button buttonRemove = (Button)findViewById(R.id.buttonRemove);
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button buttonEdit = findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                intent.putExtra("newHabbitBool", false);
                intent.putExtra("HabbitName", true);
                startActivity(intent);
            }
        });

        Button buttonHome = findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

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

}