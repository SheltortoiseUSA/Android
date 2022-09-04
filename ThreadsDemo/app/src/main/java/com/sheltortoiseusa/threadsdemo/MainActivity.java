package com.sheltortoiseusa.threadsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private boolean isWorking;
    private Button startBtn;
    private Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.start_btn);
        stopBtn = (Button) findViewById(R.id.stop_btn);

        isWorking = false;
    }
    public void workOnIt(View view) {
        if(view.getId() == R.id.start_btn) {
            if(!isWorking) {
                isWorking = true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(isWorking) {
                            Log.i(":THREAD-DEMO", "HELLO THERE");
                        }
                    }
                }).start();
            }
        }
        else {
            isWorking = false;
            Log.i(":THREAD DEMO", "GOODBYE");
        }
    }
}
