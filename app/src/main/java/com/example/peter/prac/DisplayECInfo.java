package com.example.peter.prac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 12/26/2017.
 */

public class DisplayECInfo extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ec_info);

        TextView ecInfo = (TextView) findViewById(R.id.ECInfo);
        ecInfo.setMovementMethod(new ScrollingMovementMethod());
        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");
        String info = extras.getString("info");
        String school = extras.getString("school");
        String intro = extras.getString("intro");
        ecInfo.setText(name + "\n\n"
                + info + "\n\n"
                + school + "\n\n\n\n" + intro);
        /* keys:
            name
            info
            school
            intro
         */
    }
}
