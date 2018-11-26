package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;

public class TeensMood extends AppCompatActivity {
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


        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        continue_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { nextActivity(); }
        });


    }

    public void nextActivity(){

        Intent myIntent =new Intent(this, LaughCountDown.class);
        myIntent.putExtra(EXTRA_MESSAGE, "2");
        startActivity(myIntent);
    }
}