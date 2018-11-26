package com.hci.laughtr;

import android.content.Context;
import android.content.Intent;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.TaskStackBuilder;
import android.media.MediaPlayer;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import ak.sh.ay.musicwave.MusicWave;

import java.io.IOException;

public class AnalysisScreen extends AppCompatActivity {

    private static String mFileName = null;
    private PlayButton   mPlayButton = null;
    private MediaPlayer   mPlayer = null;
    private static final String LOG_TAG = "StartScreen";
    public static final int RequestPermissionCode = 1;
    private Visualizer mVisualizer;
    private MusicWave musicWave;

    class PlayButton extends AppCompatButton {
        boolean mStartPlaying = true;

        OnClickListener clicker = new OnClickListener() {
            public void onClick(View v) {
                onPlay(mStartPlaying);
                if (mStartPlaying) {
                    setText("Stop playing");
                } else {
                    setText("Start playing");
                }
                mStartPlaying = !mStartPlaying;
            }
        };

        public PlayButton(Context ctx) {
            super(ctx);
            setText("Start playing");
            setOnClickListener(clicker);
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        musicWave = (MusicWave) findViewById(R.id.musicWave);
        mPlayer = new MediaPlayer();
        prepareVisualizer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void prepareVisualizer() {
        mVisualizer = new Visualizer(mPlayer.getAudioSessionId());
        mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
        mVisualizer.setDataCaptureListener(
                new Visualizer.OnDataCaptureListener() {
                    public void onWaveFormDataCapture(Visualizer visualizer,
                                                      byte[] bytes, int samplingRate) {
                        musicWave.updateVisualizer(bytes);
                    }

                    public void onFftDataCapture(Visualizer visualizer,
                                                 byte[] bytes, int samplingRate) {
                    }
                }, Visualizer.getMaxCaptureRate() / 2, true, false);
        mVisualizer.setEnabled(true);
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
        mVisualizer.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_screen);

        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/laugh.3gp";

        LinearLayout layout = findViewById(R.id.rootContainer);

        mPlayButton = new PlayButton(this);
        layout.addView(mPlayButton,
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));


    }

    public void onBackPressed() {
        Intent myIntent ;
        myIntent =new Intent(this, StartScreen.class);
        TaskStackBuilder builder = TaskStackBuilder.create(this);
        builder.addNextIntentWithParentStack(myIntent);
        builder.startActivities();
        mVisualizer.release();
    }

}
