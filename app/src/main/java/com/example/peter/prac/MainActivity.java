package com.example.peter.prac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when the user taps People button
    public void showPplGrps(View view) {
        Intent intent = new Intent(this, DisplayPplGrps.class);
        startActivity(intent);
    }


}
