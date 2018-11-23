package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LaughCountDown extends AppCompatActivity {

    private TextView countdownText;
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down);
        countdownText = findViewById(R.id.countdown);
    }

    protected void onStart(){
        super.onStart();
        countdownText.setText("Ready");
        final Intent myIntent = new Intent(this, LaughScreen.class);
        countDownTimer = new CountDownTimer(1 * 1000, 1000) {
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {startCountDown(myIntent);}
        };
        countDownTimer.start();
    }

    protected void onPause(){
        super.onPause();
        countDownTimer.cancel();

    }

    public void startCountDown(Intent intent){
        final Intent myIntent = intent;
        countDownTimer = new CountDownTimer(4 * 1020, 1000) {
            int count=3;
            public void onTick(long millisUntilFinished) {
                if (count ==0){
                    countdownText.setText("Laugh");
                }else countdownText.setText(count+"");
                count-=1;
            }
            public void onFinish() { startActivityForResult(myIntent, 0);}
        };

        countDownTimer.start();
    }
}
