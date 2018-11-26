package com.hci.laughtr;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.Manifest;
import android.util.Log;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import java.io.IOException;

public class LaughScreen extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    private CountDownTimer laughtTimer;
    Intent myIntent;

    private static String mFileName = null;
    private MediaRecorder mRecorder = null;

    private static final String LOG_TAG = "StartScreen";

    public static final int RequestPermissionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laugh_screen);

        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/laugh.3gp";

    }


    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }


    protected void onStart(){
        super.onStart();
        Intent maybeIntent;

        Intent intent = getIntent();
        int message = Integer.parseInt(intent.getStringExtra(EXTRA_MESSAGE));

        onRecord(true);

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
        onRecord(false);
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

    }

}
