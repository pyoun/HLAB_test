package com.example.peter.prac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DisplayHS extends AppCompatActivity {
    ListView lView;
    ListAdapter lAdapter;

    Person Rei = new Person(0, "Rei",
            "Goto","HS","Syosset High School", 18,
            "Hi my name is Rei.",0);
    Person Yuichiro = new Person(1,"Yuichiro",
            "Namba", "HS","Tokyo Metropolitan Kokusai High School",
            17,"Hi my name is Yuichiro",0);
    Person[] people = {
            Rei, Yuichiro
    };
    int[] images = {R.drawable.peter_youn, R.drawable.peter_youn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_hs);

        lView = (ListView) findViewById(R.id.HSlist);
        lAdapter = new ListAdapter(this,people,images);
        lView.setAdapter(lAdapter);
    }
}
