package com.hci.laughtr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        final ImageButton button = findViewById(R.id.ages4_7);
        final ImageButton button8_11 = findViewById(R.id.ages8_11);
        final ImageButton button12 = findViewById(R.id.ages12);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.mood_ages4_7);
            }
        });

        button8_11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.mood_ages8_11);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.mood_ages12);
            }
        });

    }
}
