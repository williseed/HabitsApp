package com.example.androidprogrammingsemesterproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ActivityItemView extends LinearLayout{
    TextView nameText, unitText, streakText, priorityText;
    ProgressBar progressBar;
    ImageView imageIcon;

    public ActivityItemView(Context context) {
        super(context);
        init(context);
    }

    public ActivityItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_item, this, true);

        nameText = (TextView) findViewById(R.id.activityName);
        unitText = (TextView) findViewById(R.id.unitsTextView);
        streakText = (TextView) findViewById(R.id.streakTextView);
        priorityText = (TextView) findViewById(R.id.priorityTextView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imageIcon = (ImageView) findViewById(R.id.activityIcon);
    }

    public void setNameText(String name) {
        nameText.setText(name);
    }

    public void setUnitText(String unit, float progress, float max) {
        unitText.setText(progress + " / " + max + " " + unit + "(s)");
    }

    public void setStreakText(int streak) {
        streakText.setText("Streak: " + streak);
    }

    public void setPriorityText(String priority) {
        priorityText.setText("Priority: " + priority);
    }

    public void setProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void setProgressBarMax(int progressBarMax){
        this.progressBar.setMax(progressBarMax);
    };

    public void setImageIcon(int resID) {
        imageIcon.setImageResource(resID);
    }
}
