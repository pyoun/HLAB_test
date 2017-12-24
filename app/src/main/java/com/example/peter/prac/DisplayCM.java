package com.example.peter.prac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DisplayCM extends AppCompatActivity {
    ListView lView;
    ListAdapter lAdapter;

    Person Peter = new Person(0, "Peter",
            "Youn", "CM", "Harvard University", 22,
            "Hi my name is Peter Youn.", 0);
    Person Sien = new Person(1,"Sien",
            "Liu", "CM","University of Gent", 53,
            "Hi my name is Sien Liu.",0);
    Person[] people = {
            Peter, Sien
    };
    int[] images = {R.drawable.peter_youn, R.drawable.peter_youn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cm);

        lView = (ListView) findViewById(R.id.CMlist);
        lAdapter = new ListAdapter(this,people,images);
        lView.setAdapter(lAdapter);
    }
}
