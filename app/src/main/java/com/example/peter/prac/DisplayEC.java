package com.example.peter.prac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DisplayEC extends AppCompatActivity {
    ListView lView;
    ListAdapter lAdapter;

    Person Yoshi = new Person(0, "Tsuyoshi", "Toshita",
            "EC", "Keio University", 23,"Hi my name is Yoshi.", 0);
    Person Karen = new Person(1,"Karen",
            "Matsumoto", "EC","Stony Brook University", 23,
            "Hi my name is Karen.",0);
    Person[] people = {
            Yoshi, Karen
    };
    int[] images = {R.drawable.peter_youn, R.drawable.peter_youn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ec);

        lView = (ListView) findViewById(R.id.EClist);
        lAdapter = new ListAdapter(this,people,images);
        lView.setAdapter(lAdapter);
    }
}
