package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {
    HomeFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment);
    }
}