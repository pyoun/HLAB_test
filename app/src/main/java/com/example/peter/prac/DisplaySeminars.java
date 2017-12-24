package com.example.peter.prac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Peter on 12/24/2017.
 */

public class DisplaySeminars extends AppCompatActivity {

    ListView lView;
    SemAdapter lAdapter;

    Seminar StoryWOWords = new Seminar(0,"Stories without Words",
            "Peter Youn","Hiro Kawakatsu",
            "This is an introduction to a seminar.",0);
    Seminar AnotherSeminar = new Seminar(1,"Another Seminar",
            "Some CM","Some EC",
            "This is an introduction to a seminar.",1);
    Seminar[] seminars = {
            StoryWOWords, AnotherSeminar
    };
    int[] sempics = {R.drawable.music_note, R.drawable.music_note};

    Person Peter = new Person(0,"Peter","Youn",
            "CM","Harvard University",22,
            "Hi my name is Peter.",0);
    Person Hiro = new Person(1, "Hiroshi", "Kawakatsu",
            "EC","Haverford College",19,
            "Hi my name is Hiro.",1);
    Person[] people = { Peter, Hiro };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_seminars);

        lView = (ListView) findViewById(R.id.SeminarList);
        lAdapter = new SemAdapter(this, seminars, sempics);
        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(view.getContext(), DisplaySeminarInfo.class);
                String pos = parent.getPositionForView(view) + "";
                myIntent.putExtra("clickpos", pos);
                startActivityForResult(myIntent, 0);
            }
            /*
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = parent.getPositionForView(view);
                Toast.makeText(getApplicationContext(), pos + "", Toast.LENGTH_LONG).show();
            }*/
        });
    }
}
