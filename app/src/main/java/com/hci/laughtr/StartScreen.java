package com.hci.laughtr;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.content.Intent;

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
                Intent myIntent = new Intent(v.getContext(), ToddlerMood.class);
                startActivityForResult(myIntent, 0);
            }
        });

        button8_11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), KidsMood.class);
                startActivityForResult(myIntent, 0);
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), TeensMood.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

}
