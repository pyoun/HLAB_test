package com.example.peter.prac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DisplayEC extends AppCompatActivity {
    ListView lView;
    PerAdapter lAdapter;

    int[] images = {R.drawable.peter_youn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ec);

        ReadFile peopleCSV = new ReadFile();
        final Person[] people = peopleCSV.readPplCSV(this,"EC");
        lView = (ListView) findViewById(R.id.EClist);
        Arrays.sort(people);
        lAdapter = new PerAdapter(this,people,images);
        lView.setAdapter(lAdapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(view.getContext(), DisplayCMInfo.class);
                int clickedPos = parent.getPositionForView(view);
                Person clickedPerson = people[clickedPos];

                List<String> key = new ArrayList<String>();
                List<String> val = new ArrayList<String>();
                Collections.addAll(key, "name","info","school","intro");
                Collections.addAll(val,clickedPerson.firstName +" "+ clickedPerson.lastName,
                        clickedPerson.age + ", " + clickedPerson.role,
                        clickedPerson.school,
                        clickedPerson.intro);
                for (int i = 0; i < key.size(); i++) {
                    myIntent.putExtra(key.get(i), val.get(i));
                }

                startActivityForResult(myIntent, 0);
            }
        });
    }
}
