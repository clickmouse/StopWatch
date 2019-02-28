package com.example.stopwatch2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Button button;
    ImageView imageView;
    Animation animation,btngone,btntwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text_view);
        text2 = findViewById(R.id.text_view2);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.background);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        btngone = AnimationUtils.loadAnimation(this,R.anim.btngone);
        btntwo = AnimationUtils.loadAnimation(this,R.anim.btntwo);
        imageView.startAnimation(animation);
        text1.startAnimation(btngone);
        text2.startAnimation(btngone);
        button.startAnimation(btntwo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(MainActivity.this, StopWatch.class);
                view.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(view);
            }
        });
    }
}
