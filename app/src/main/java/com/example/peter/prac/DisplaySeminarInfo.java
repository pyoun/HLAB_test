package com.example.peter.prac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by Peter on 12/24/2017.
 */

public class DisplaySeminarInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_seminar_info);

        TextView seminarInfo = (TextView) findViewById(R.id.SeminarInfo);
        seminarInfo.setMovementMethod(new ScrollingMovementMethod());
        Bundle extras = getIntent().getExtras();
        /*String value = extras.getString("clickpos");
        Seminar smr = seminars[Integer.parseInt(value)];
        String info = smr.seminarName + "\n"
                + smr.cmName + ", " + smr.ecName + "\n\n"
                + smr.seminarIntro;*/
        String semInfo = extras.getString("SeminarInfo");
        //seminarInfo.setText(info);
        seminarInfo.setText(semInfo);
    }
}
