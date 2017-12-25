package com.example.peter.prac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by Peter on 12/26/2017.
 */

public class DisplayHSInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_hs_info);

        TextView hsInfo = (TextView) findViewById(R.id.HSInfo);
        hsInfo.setMovementMethod(new ScrollingMovementMethod());
        Bundle extras = getIntent().getExtras();

        String name = extras.getString("name");
        String info = extras.getString("info");
        String school = extras.getString("school");
        String intro = extras.getString("intro");
        hsInfo.setText(name + "\n\n"
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
