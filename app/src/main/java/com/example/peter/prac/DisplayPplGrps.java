package com.example.peter.prac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayPplGrps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_ppl_grps);
    }

    public void showEC(View view) {
        Intent intent = new Intent(this, DisplayEC.class);
        startActivity(intent);
    }
    public void showCM(View view) {
        Intent intent = new Intent(this, DisplayCM.class);
        startActivity(intent);
    }
    public void showHS(View view) {
        Intent intent = new Intent(this, DisplayHS.class);
        startActivity(intent);
    }
}
