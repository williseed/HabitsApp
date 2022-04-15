package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

public class HabbitsActivity extends AppCompatActivity {
    String currentString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbits);

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

}