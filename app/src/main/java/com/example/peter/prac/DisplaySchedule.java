package com.example.peter.prac;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Peter on 12/26/2017.
 */

public class DisplaySchedule extends AppCompatActivity {
    ListView lView;
    ArrayAdapter<String> lAdapter;
    int days = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schedule);

        String[] scheduleList = {"Day 1", "Day 2"};
        ArrayList<String> schedules = new ArrayList<String>();
        schedules.addAll(Arrays.asList(scheduleList));

        lView = (ListView) findViewById(R.id.ScheduleList);
        lAdapter = new ArrayAdapter<String> (this,
                R.layout.display_schedule_row, schedules);
        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(view.getContext(), DisplayScheduleInfo.class);
                String pos = parent.getPositionForView(view) + "";
                myIntent.putExtra("clickPosition", pos);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
