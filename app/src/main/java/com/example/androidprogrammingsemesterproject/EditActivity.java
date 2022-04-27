package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class EditActivity extends AppCompatActivity {

    Bundle extras = getIntent().getExtras();

    boolean newHabbitBool = extras.getBoolean("newHabbitBool") ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ////////////////////////////////////
        EditText HabbitName = findViewById(R.id.NameView);
        EditText HabbitDescription= findViewById(R.id.NoteView);
        RadioButton radioWork = findViewById(R.id.radioWork);
        RadioButton radioHealth = findViewById(R.id.radioHealth);
        RadioButton radioSchool = findViewById(R.id.radioSchool);
        ImageView imageSET = findViewById(R.id.imageView);
        Button SaveButton = findViewById(R.id.buttonSave);
        String name =HabbitName.toString();
        /////////////////////////////////////
        radioWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            radioSchool.setChecked(false);
            radioHealth.setChecked(false);
            }
        });
        radioHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioWork.setChecked(false);
                radioSchool.setChecked(false);
            }
        });
        radioSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioWork.setChecked(false);
                radioHealth.setChecked(false);
            }
        });

SaveButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //saves all current information in the form inside of object
            HabbitObject newHabbit = new HabbitObject(name);
            newHabbit.description = HabbitDescription.toString();
            newHabbit.image = imageSET.getDrawable();

            if (radioHealth.isChecked()) {
                newHabbit.type = "Health";

            }
            else if (radioWork.isChecked()) {
                newHabbit.type = "Work";

            }
            else if (radioSchool.isChecked()) {
                newHabbit.type = "School";

            }


        boolean chipReady = false;
        Intent intent = new Intent(getApplicationContext(), HabbitsActivity.class);
        intent.putExtra("HabbitObjectName", name);
        intent.putExtra("chipReady", true);
        startActivity(intent);
        //these passed variables go back to HabbitActivity
    }
});
    }
}