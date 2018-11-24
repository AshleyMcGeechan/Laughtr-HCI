package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class LaughCountDown extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private GifImageView loadinggif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down);
        countdownText = findViewById(R.id.countdown);
        loadinggif = findViewById(R.id.gifImageView2);
    }

    protected void onStart(){
        super.onStart();
        countdownText.setText("Ready");

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        final Intent myIntent = new Intent(this, LaughScreen.class);
        myIntent.putExtra(EXTRA_MESSAGE, message);

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
        loadinggif.setVisibility(View.VISIBLE);
        countDownTimer = new CountDownTimer(4 * 1020, 1000) {
            int count=3;
            public void onTick(long millisUntilFinished) {
                if (count ==0){
                    loadinggif.setVisibility(View.INVISIBLE);
                    countdownText.setText("Laugh");
                }else countdownText.setText(count+"");
                count-=1;
            }
            public void onFinish() { startActivityForResult(myIntent, 0);finish();}
        };

        countDownTimer.start();
    }
}
