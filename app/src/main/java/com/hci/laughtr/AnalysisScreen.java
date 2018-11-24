package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.TaskStackBuilder;

public class AnalysisScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_screen);
    }

    public void onBackPressed() {
        Intent myIntent ;
        myIntent =new Intent(this, StartScreen.class);
        TaskStackBuilder builder = TaskStackBuilder.create(this);
        builder.addNextIntentWithParentStack(myIntent);
        builder.startActivities();
    }

}
