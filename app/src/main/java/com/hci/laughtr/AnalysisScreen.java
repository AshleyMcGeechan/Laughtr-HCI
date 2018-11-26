package com.hci.laughtr;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

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
