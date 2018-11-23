package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class KidsMood extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ages8_11);
        final ImageButton plainbtn = findViewById(R.id.plainFace);
        final ImageButton sadbtn = findViewById(R.id.sadFace);
        final ImageButton happybtn = findViewById(R.id.happyFace);
        final ImageButton angrybtn = findViewById(R.id.angryFace);
        final ImageButton sleepybtn = findViewById(R.id.sleepyFace);

        final Intent myIntent = new Intent(this, LaughCountDown.class);
        plainbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { startActivityForResult(myIntent, 0); }
        });
        sadbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { startActivityForResult(myIntent, 0);}
        });
        happybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {startActivityForResult(myIntent, 0); }
        });

        angrybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {startActivityForResult(myIntent, 0);}

        });

        sleepybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {startActivityForResult(myIntent, 0); }
        });



    }
}
