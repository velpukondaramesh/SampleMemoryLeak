package com.example.ratheesh.samplememoryleak;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView txt;


    private final Handler mLeakyHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        txt.setText("First");

        mLeakyHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000 * 60 * 10);

        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}



//reference from https://www.androiddesignpatterns.com/2013/04/activitys-threads-memory-leaks.html