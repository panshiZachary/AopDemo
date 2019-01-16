package com.example.aopdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aopdemo.annomation.BehaviorTrace;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 摇一摇
     * @param view
     */
    @BehaviorTrace("摇一摇")
    public void mShake(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }

    /**
     * 语音
     * @param view
     */
    public void mAudio(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }

    /**
     * 视频
     * @param view
     */
    public void mVideo(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }

    /**
     * 说说
     * @param view
     */
    public void mSay(View view) {
        SystemClock.sleep(new Random().nextInt(2000));
    }
}
