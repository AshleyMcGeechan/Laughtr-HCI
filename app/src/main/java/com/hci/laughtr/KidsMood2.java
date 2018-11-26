package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class KidsMood2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    private TextView feelText;
    boolean end = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ages8_11);
        feelText = findViewById(R.id.feelText);

    }

    protected void onStart(){
        super.onStart();
        final ImageButton plainbtn = findViewById(R.id.plainFace);
        final ImageButton sadbtn = findViewById(R.id.sadFace);
        final ImageButton happybtn = findViewById(R.id.happyFace);
        final ImageButton angrybtn = findViewById(R.id.angryFace);
        final ImageButton sleepybtn = findViewById(R.id.sleepyFace);


        feelText.setText("How About Now?");


        plainbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });
        sadbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });
        happybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity(); }
        });

        angrybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });

        sleepybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });


    }


    public void nextActivity(){
        Intent myIntent ;
        myIntent =new Intent(this, AnalysisScreen.class);
        startActivity(myIntent);
    }
}
