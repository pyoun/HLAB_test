package com.example.peter.prac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by Peter on 12/24/2017.
 */

public class DisplaySeminars extends AppCompatActivity {

    ListView lView;
    SemAdapter lAdapter;

    Seminar StoryWOWords = new Seminar(0,"Stories without Words","Peter Youn","Hiro Kawakatsu",0);
    Seminar AnotherSeminar = new Seminar(1,"Another Seminar", "Some CM","Some EC", 1);
    Seminar[] seminars = {
            StoryWOWords, AnotherSeminar
    };
    int[] sempics = {R.drawable.music_note, R.drawable.music_note};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_seminars);

        lView = (ListView) findViewById(R.id.SeminarList);
        lAdapter = new SemAdapter(this,seminars,sempics);
        lView.setAdapter(lAdapter);
    }
}
