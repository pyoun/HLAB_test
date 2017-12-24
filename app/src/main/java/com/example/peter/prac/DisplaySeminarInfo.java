package com.example.peter.prac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Peter on 12/24/2017.
 */

public class DisplaySeminarInfo extends AppCompatActivity {
    Seminar StoryWOWords = new Seminar(0,"Stories without Words",
            "Peter Youn","Hiro Kawakatsu",
            "This is an introduction to a seminar.",0);
    Seminar AnotherSeminar = new Seminar(1,"Another Seminar",
            "Some CM","Some EC",
            "This is an introduction to a seminar.",1);
    Seminar[] seminars = {
            StoryWOWords, AnotherSeminar
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_seminar_info);

        TextView seminarInfo = (TextView) findViewById(R.id.SeminarInfo);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("clickpos");
        Seminar smr = seminars[Integer.parseInt(value)];
        String info = smr.seminarName + "\n"
                + smr.cmName + ", " + smr.ecName + "\n\n"
                + smr.seminarIntro;
        seminarInfo.setText(info);
    }
}
