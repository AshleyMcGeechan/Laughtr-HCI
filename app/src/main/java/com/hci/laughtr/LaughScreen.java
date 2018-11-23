package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

public class LaughScreen extends AppCompatActivity {

    private CountDownTimer laughtTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laugh_screen);
    }

    protected void onStart(){
        super.onStart();
        final Intent myIntent = new Intent(this, KidsMood.class);
        laughtTimer = new CountDownTimer(8 * 1000 , 1000) {
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                startActivityForResult(myIntent, 0);

            }
        };
        laughtTimer.start();
    }

    protected void onPause(){
        super.onPause();
        laughtTimer.cancel();

    }

}
