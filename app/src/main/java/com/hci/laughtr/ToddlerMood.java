package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ToddlerMood extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    private TextView feelText;
    boolean end = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ages4_7);
        feelText = findViewById(R.id.feelText);
    }

    protected void onStart(){
        super.onStart();
        final ImageView sadbtn = findViewById(R.id.toddlerSad);
        final ImageView happybtn = findViewById(R.id.toddlerHappy);
        final ImageView angrybtn = findViewById(R.id.toddlerAngry);
        final ImageView scaredbtn = findViewById(R.id.toddlerScared);

        feelText = findViewById(R.id.toddlerFeeling);

        sadbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });
        happybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity(); }
        });
        angrybtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });
        scaredbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {nextActivity();}
        });
    }


    public void nextActivity(){
        Intent myIntent = new Intent(this, LaughCountDown.class);
        myIntent.putExtra(EXTRA_MESSAGE, "0");
        startActivity(myIntent);
    }
}
