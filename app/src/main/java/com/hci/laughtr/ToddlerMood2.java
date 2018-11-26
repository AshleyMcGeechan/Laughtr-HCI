package com.hci.laughtr;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ToddlerMood2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    private TextView feelText;
    boolean end = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ages4_7);
        feelText = findViewById(R.id.toddlerFeeling);
    }

    protected void onStart(){
        super.onStart();
        final ImageView sadbtn = findViewById(R.id.toddlerSad);
        final ImageView happybtn = findViewById(R.id.toddlerHappy);
        final ImageView angrybtn = findViewById(R.id.toddlerAngry);
        final ImageView scaredbtn = findViewById(R.id.toddlerScared);

        feelText.setText("How About Now?");
        final Intent myIntent = new Intent(this, LaughCountDown.class);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
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
        Intent myIntent ;
        myIntent =new Intent(this, AnalysisScreen.class);
        startActivity(myIntent);
    }
}
