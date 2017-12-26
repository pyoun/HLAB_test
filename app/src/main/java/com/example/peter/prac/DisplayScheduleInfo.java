package com.example.peter.prac;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 12/26/2017.
 */

public class DisplayScheduleInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_schedule_info);

        TextView scheduleInfo = (TextView) findViewById(R.id.ScheduleInfo);
        //scheduleInfo.setMovementMethod(new ScrollingMovementMethod());
        Bundle extras = getIntent().getExtras();
        String position = extras.getString("clickPosition");
        position = "1";
        String fileName = "schedule_day" + position + ".csv";

        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream = null;
        List<Schedule> tempSchedule = new ArrayList<Schedule>();

        try {
            inputStream = assetManager.open(fileName);
            if (inputStream != null) {
                Log.d("X", "STREAM SUCCESS");
            }
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream,
                    "UTF-8"));
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                tempSchedule.add(new Schedule(
                        Integer.parseInt(line[0]),
                        line[1], line[2],
                        line[3], line[4], line[5]));
            }

            Schedule[] scheduleList = new Schedule[ tempSchedule.size() ];
            tempSchedule.toArray(scheduleList);

            String dispTxt = "";
            /* for gravity center
            for (int i = 0; i < scheduleList.length; i++) {
                dispTxt += scheduleList[i].startTime + " - " + scheduleList[i].endTime + "\n"
                        + scheduleList[i].eventName + "\n"
                        + scheduleList[i].eventLocation + "\n"
                        + scheduleList[i].eventInfo + "\n\n";
            }*/

            for (int i = 0; i < scheduleList.length; i++) {
                dispTxt += scheduleList[i].startTime + " - " + scheduleList[i].endTime + "\n"
                        + scheduleList[i].eventName + "\n\n"
                        + "Location: " + scheduleList[i].eventLocation + "\n"
                        + "Info: " + scheduleList[i].eventInfo + "\n\n\n\n";
            }
            scheduleInfo.setText(dispTxt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
