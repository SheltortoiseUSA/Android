package com.sheltortoiseusa.followmeandroidbuddy;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private ImageView friendImage;
    private Friend friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friend = new Friend(100, 100, 100, 100, 5);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        friendImage = (ImageView) layoutInflater.inflate(R.layout.friend_layout, null);

        friendImage.setX(friend.currentX);
        friendImage.setY(friend.currentY);

        friendImage.setScaleX(.5f);
        friendImage.setScaleY(.5f);

        relativeLayout.addView(friendImage, 0);

        Thread thread = new Thread(backgroundCalc);
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int touchAction = e.getActionMasked();

        int fingerX = friend.targetX;
        int fingerY = friend.targetY;

        switch(touchAction) {
            case MotionEvent.ACTION_UP: {
                fingerX = (int) e.getX();
                fingerY = (int) e.getY();

                break;
            }
            case MotionEvent.ACTION_DOWN: {
                fingerX = (int) e.getX();
                fingerY = (int) e.getY();

                break;
            }
            case MotionEvent.ACTION_MOVE: {
                fingerX = (int) e.getX();
                fingerY = (int) e.getY();

                break;
            }
        }
        friend.targetX = fingerX;
        friend.targetY = fingerY;

        return true;
    }
    private Runnable backgroundCalc = new Runnable() {
        private static final int DELAY = 100;

        public void run() {
            try {
                while(true) {
                    friend.move();
                    Thread.sleep(DELAY);
                    handler.sendEmptyMessage(0);
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    public Handler handler = new Handler() {
        public void handleMessage(android.os.MessageQueue msg) {
            friendImage.setX((float) friend.currentX);
            friendImage.setY((float) friend.currentY);
        }
    };
}
