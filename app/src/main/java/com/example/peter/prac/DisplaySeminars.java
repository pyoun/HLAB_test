package com.example.peter.prac;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 * Created by Peter on 12/24/2017.
 */

public class DisplaySeminars extends AppCompatActivity {
    ListView lView;
    SemAdapter lAdapter;

    int[] sempics = {R.drawable.music_note};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_seminars);

        ReadFile seminarsCSV = new ReadFile();
        final Seminar[] seminars = seminarsCSV.readSemCSV(this);
        lView = (ListView) findViewById(R.id.SeminarList);
        lAdapter = new SemAdapter(this, seminars, sempics);
        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(view.getContext(), DisplaySeminarInfo.class);
                //String pos = parent.getPositionForView(view) + "";
                //myIntent.putExtra("clickpos", pos);
                int clickedPos = parent.getPositionForView(view);
                Seminar clickedSem = seminars[clickedPos];
                String semInfo = clickedSem.seminarName+"\n\n"
                        + clickedSem.cmName +"\n"+ clickedSem.ecName +"\n\n"
                        + clickedSem.seminarStudents +"\n\n\n\n"
                        + clickedSem.seminarIntro;
                myIntent.putExtra("SeminarInfo", semInfo);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
