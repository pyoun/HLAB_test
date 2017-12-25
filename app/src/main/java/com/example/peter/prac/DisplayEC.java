package com.example.peter.prac;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;


public class DisplayEC extends AppCompatActivity {
    ListView lView;
    ListAdapter lAdapter;

    int[] images = {R.drawable.peter_youn};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ec);

        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream = null;
        List<Person> tempppl = new ArrayList<Person>();

        try {
            inputStream = assetManager.open("people.csv");
            if (inputStream != null) {
                Log.d("X", "STREAM SUCCESS");
            }
            CSVReader reader = new CSVReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            String[] line;
            reader.readNext();
            while ((line = reader.readNext()) != null) {
                if (line[3].equals("EC")) {
                    tempppl.add(new Person(Integer.parseInt(line[0]),
                            line[1], line[2], line[3], line[4],
                            Integer.parseInt(line[5]),
                            line[6],0));
                }
            }
            final Person[] people = new Person[ tempppl.size() ];
            tempppl.toArray(people);
            // the three lines below determine the view
            // move outside of try when deleting try-catch
            lView = (ListView) findViewById(R.id.EClist);
            lAdapter = new ListAdapter(this,people,images);
            lView.setAdapter(lAdapter);

            lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(view.getContext(), DisplayECInfo.class);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
