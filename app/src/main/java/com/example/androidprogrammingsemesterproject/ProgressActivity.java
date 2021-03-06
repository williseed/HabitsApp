package com.example.androidprogrammingsemesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class ProgressActivity extends AppCompatActivity {
    ActivityAdapter adapter;
    ProgressBar totalActivitiesPB;
    Button editSelectedBtn, homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        ListView listView = (ListView) findViewById(R.id.progressListView);
        totalActivitiesPB = (ProgressBar) findViewById(R.id.totalActPB);
        editSelectedBtn = (Button) findViewById(R.id.editSelActInProgress);
        //homeBtn = (Button) findViewById(R.id.homeFromProgress);

        adapter = new ActivityAdapter();

        adapter.addItem(new ActivityItem("Running","Mile",3,6.213,0,R.drawable.running,0));
        adapter.addItem(new ActivityItem("Working","Report",1,100,36,R.drawable.working,10));
        adapter.addItem(new ActivityItem("Studying","Hour",1,10,5,R.drawable.working,0));
        adapter.addItem(new ActivityItem("Naps","Nap",2,10,2,R.drawable.sleeping,0));
        adapter.addItem(new ActivityItem("Workouts","Workout",3,5,3,R.drawable.running,2));

        listView.setAdapter(adapter);
        /*
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        */

        editSelectedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
            itemView.setUnitText(item.getUnitType(), (int)item.getdoubleProgress(), (int)item.getdoubleMax() );
            itemView.setProgressBar((int) item.getdoubleProgress());
            itemView.setProgressBarMax((int)item.getdoubleMax());
            itemView.setImageIcon(item.getResID());
            itemView.setPriorityText(item.getActivityPriority());
            itemView.setStreakText(item.getStreak());

            return itemView;
        }

        public void addItem(ActivityItem item){
            items.add(item);
        }
    }
}