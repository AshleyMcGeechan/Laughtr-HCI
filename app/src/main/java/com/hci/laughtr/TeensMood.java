package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class TeensMood extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mood_ages12);
        final ImageButton continue_button = findViewById(R.id.continue_button);
        final Intent myIntent = new Intent(this, LaughCountDown.class);
        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { startActivityForResult(myIntent, 0); }
        });
    }
}