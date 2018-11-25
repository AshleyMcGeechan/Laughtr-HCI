package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;


public class LaughScreen extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    private CountDownTimer laughtTimer;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laugh_screen);
    }

    protected void onStart(){
        super.onStart();
        Intent maybeIntent;

        Intent intent = getIntent();
        int message = Integer.parseInt(intent.getStringExtra(EXTRA_MESSAGE));

        if (message ==0)maybeIntent = new Intent(this, ToddlerMood2.class);
        else if (message ==1) maybeIntent = new Intent(this, KidsMood2.class);
        else if (message ==2)maybeIntent = new Intent(this, TeensMood2.class);
        else maybeIntent = new Intent(this, StartScreen.class);

        myIntent = maybeIntent;
        myIntent.putExtra(EXTRA_MESSAGE, "End");

        laughtTimer = new CountDownTimer(5 * 1000 , 1000) {
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                startActivity(myIntent);
//                finish();

            }
        };
        laughtTimer.start();
    }

    protected void onPause(){
        super.onPause();
        laughtTimer.cancel();

    }

}
