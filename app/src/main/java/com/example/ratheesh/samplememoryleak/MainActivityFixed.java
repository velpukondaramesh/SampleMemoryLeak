package com.example.ratheesh.samplememoryleak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivityFixed extends AppCompatActivity {

    private static class MyHandler extends Handler {
        private final WeakReference<MainActivityFixed> mActivity;

        public MyHandler(MainActivityFixed activity) {
            mActivity = new WeakReference<MainActivityFixed>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivityFixed activity = mActivity.get();
            if (activity != null) {

            }
        }
    }

    private static final Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    private final MyHandler mHandler = new MyHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt = findViewById(R.id.txt);
        txt.setText("First");

        mHandler.postDelayed(runnable, 1000 * 60 * 10);

        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}
