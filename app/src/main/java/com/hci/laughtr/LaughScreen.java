package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.annotation.NonNull;

import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;


public class LaughScreen extends AppCompatActivity{
    public static final String EXTRA_MESSAGE = "com.hci.laughtr.MESSAGE";
    public static final String API_KEY = "AIzaSyCoVjHfxFd2U-b43v7ru8AzHaiUycugHAs";
    private CountDownTimer laughtTimer;
    Intent myIntent;
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laugh_screen);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull final YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        String videoId = "6JYIGclVQdw";
                        initializedYouTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }
        }, true);
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

        laughtTimer = new CountDownTimer(15 * 1000 , 1000) {
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
