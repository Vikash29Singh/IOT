package com.example.index;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Index extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    Animation ud, du;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);
        ud = AnimationUtils.loadAnimation(this, R.anim.ud);
        du = AnimationUtils.loadAnimation(this, R.anim.du);
        //Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(ud);
        iv.startAnimation(du);
        final Intent i = new Intent(this, Index2.class);
        Thread timer = new Thread() {
            public void run () {
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();

    }
}
