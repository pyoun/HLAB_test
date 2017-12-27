package com.example.peter.prac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


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

        String dispTxt = "";
        ReadFile schedule = new ReadFile();
        Schedule[] scheduleList = schedule.readSchCSV(this, position);
        for (int i = 0; i < scheduleList.length; i++) {
            dispTxt += scheduleList[i].startTime + " - " + scheduleList[i].endTime + "\n"
                    + scheduleList[i].eventName + "\n\n"
                    + "Location: " + scheduleList[i].eventLocation + "\n"
                    + "Info: " + scheduleList[i].eventInfo + "\n\n\n\n";
        }
        scheduleInfo.setText(dispTxt);
    }
}
