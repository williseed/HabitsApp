package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
    }

    // action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    class ActivityAdapter extends BaseAdapter{
        ArrayList<ActivityItem> items = new ArrayList<ActivityItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ActivityItemView itemView = new ActivityItemView(getApplicationContext());
            ActivityItem item = items.get(position);
            itemView.setNameText(item.getName());
            itemView.setUnitText(item.getUnitType());
            itemView.setProgressBar(item.getIntProgress());
            itemView.setImageIcon(item.getResID());
            //itemView.setPriorityText(item.getActivityPriority());
            //itemView.setStreakText(item.getStreak());

            return itemView;
        }
    }
}