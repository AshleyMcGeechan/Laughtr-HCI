package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class TeensMood2 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ages12);

    }


    protected void onStart(){
        super.onStart();
        final ImageButton continue_button = findViewById(R.id.continue_button);
        final Intent myIntent = new Intent(this, LaughCountDown.class);
        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { nextActivity(); }
        });

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { nextActivity(); }
        });



    }

    public void nextActivity(){
        Intent myIntent ;
        myIntent =new Intent(this, AnalysisScreen.class);
        startActivity(myIntent);
    }
}