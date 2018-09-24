package com.example.ratheesh.samplememoryleak.UsigThread;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.example.ratheesh.samplememoryleak.R;

public class MainActivityFixed extends AppCompatActivity {

    private MyThread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exampleThree();
    }

    private void exampleThree() {
        mThread = new MyThread();
        mThread.start();
    }

    /**
     * Static inner classes don't hold implicit references to their
     * enclosing class, so the Activity instance won't be leaked across
     * configuration changes.
     */
    private static class MyThread extends Thread {
        private boolean mRunning = false;

        @Override
        public void run() {
            mRunning = true;
            while (mRunning) {
                SystemClock.sleep(1000);
            }
        }

        public void close() {
            mRunning = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mThread.close();
    }
}
