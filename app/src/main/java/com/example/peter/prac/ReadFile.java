package com.example.peter.prac;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 12/28/2017.
 */

public class ReadFile extends AppCompatActivity{
    public Person[] readPplCSV(Context context, String role) {
        AssetManager assetManager = context.getAssets();
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
                if (line[3].equals(role)) {
                    tempppl.add(new Person(Integer.parseInt(line[0]),
                            line[1], line[2], line[3], line[4],
                            Integer.parseInt(line[5]),
                            line[6],0));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person[] people = new Person[ tempppl.size() ];
        tempppl.toArray(people);

        return people;
    }
}
