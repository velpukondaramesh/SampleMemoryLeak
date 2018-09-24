package com.example.ratheesh.samplememoryleak.UsigThread;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import com.example.ratheesh.samplememoryleak.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //exampleOne();
        exampleTwo(); //this is fixed version
    }

    private void exampleOne() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(1000);
                }
            }
        }.start();
    }



    //Solved but when orientation changed memory leaks
    private void exampleTwo() {
        new MyThread().start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }
}
