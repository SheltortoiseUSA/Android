package com.sheltortoiseusa.threadcount;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Integer count;
    public boolean isWorking;

    public Handler handler;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(getApplicationContext().getMainLooper());
        textView = (TextView) findViewById(R.id.textView);

        count = 0;
        isWorking = false;
    }
    public void workItOut(View view) {
        if(view.getId() == R.id.button2) {
            isWorking = false;
        }
        else {
            isWorking = true;

            Thread backgroundThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(isWorking) {
                        try {
                            Thread.sleep(500);
                            count++;
                        }
                        catch (InterruptedException e) {
                            Log.i("ERROR", "Error");
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(" " + count.toString());
                            }
                        });
                    }
                }
            });
            backgroundThread.start();
        }
    }
}