package com.example.stopwatch2;

import android.graphics.Interpolator;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {

    Button btnstart,btnstop;
    ImageView pointer;
    Animation round;
    Chronometer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btnstart = findViewById(R.id.btnstart);
        pointer = findViewById(R.id.pointer);
        btnstop = findViewById(R.id.btnstop);
        time = findViewById(R.id.time);
        round = AnimationUtils.loadAnimation(this,R.anim.round);
        round.setInterpolator(new LinearInterpolator());
        btnstop.setAlpha(0);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointer.startAnimation(round);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                time.setBase(SystemClock.elapsedRealtime());
                time.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
