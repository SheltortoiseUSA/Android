package com.sheltortoiseusa.timestamper;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public TextView timeDisplay;
    public ListView listView;
    public ArrayList<TimeStamp> arrayList = new ArrayList<TimeStamp>();

    public TimeStampAdapter adapter;
    public WatchTime watchTime;
    public long timeInMilliseconds = 0L;
    public Handler handler;

    public Button startBtn;
    public Button stopBtn;
    public Button resetBtn;

    public Button comedyBtn;
    public Button operationHealthBtn;
    public Button hacksBtn;
    public Button rushBtn;
    public Button standardBtn;
    public Button aceBtn;
    public Button skillshotBtn;
    public Button hardscopeBtn;
    public Button vehicleSpreeBtn;
    public Button cinematicBtn;
    public Button roadkillBtn;
    public Button longshotBtn;
    public Button meleeBtn;
    public Button grenadeBtn;
    public Button noobTubeBtn;
    public Button quickscopeBtn;
    public Button whipshotBtn;
    public Button precisionBtn;

    public String commentText="";

    public String comedy = "COM";
    public String opeationHealth = "OH";
    public String hacks = "HAX";
    public String rush = "RUSH";
    public String standard = "STD";
    public String ace = "ACE";
    public String skillshot = "SS";
    public String hardscope = "HS";
    public String vehicleSpree = "VS";
    public String cinematic = "CINE";
    public String roadkill = "RK";
    public String longshot = "LS";
    public String melee = "MELEE";
    public String grenade = "NADE";
    public String nubeTube = "NUBE";
    public String quickscope = "QS";
    public String whipshot = "WS";
    public String precision = "PS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage);

        watchTime = new WatchTime();
        handler = new Handler();
        listView = (ListView) findViewById(R.id.listView);

        commentText = "TAG";
        timeDisplay = (TextView) findViewById(R.id.timer);

        startBtn = (Button) findViewById(R.id.startButton);
        stopBtn = (Button) findViewById(R.id.stopButton);
        resetBtn = (Button) findViewById(R.id.resetButton);

        stopBtn.setEnabled(false);
        resetBtn.setEnabled(false);

        comedyBtn = (Button) findViewById(R.id.comedyButton);
        operationHealthBtn = (Button) findViewById(R.id.operationHealthButton);
        hacksBtn = (Button) findViewById(R.id.hacksButton);
        rushBtn = (Button) findViewById(R.id.rushButton);
        standardBtn = (Button) findViewById(R.id.standardButton);
        aceBtn = (Button) findViewById(R.id.aceButton);
        skillshotBtn = (Button) findViewById(R.id.skillshotButton);
        hardscopeBtn = (Button) findViewById(R.id.hardScopeButton);
        vehicleSpreeBtn = (Button) findViewById(R.id.vehicleSpreeButton);
        cinematicBtn = (Button) findViewById(R.id.cinematicButton);
        roadkillBtn = (Button) findViewById(R.id.roadkillButton);
        longshotBtn = (Button) findViewById(R.id.longshotButton);
        meleeBtn = (Button) findViewById(R.id.meleeButton);
        grenadeBtn = (Button) findViewById(R.id.grenadeButton);
        noobTubeBtn = (Button) findViewById(R.id.nubeTubeButton);
        quickscopeBtn = (Button) findViewById(R.id.quickscopeButton);
        whipshotBtn = (Button) findViewById(R.id.whipshotButton);
        precisionBtn = (Button) findViewById(R.id.precisionButton);
    }
    public void startTimer(View view) {
        stopBtn.setEnabled(true);
        resetBtn.setEnabled(false);

        watchTime.setStartTime(SystemClock.uptimeMillis());
        handler.postDelayed(updateTimerRunnable, 20);
    }
    private Runnable updateTimerRunnable = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - watchTime.getStartTime();
            watchTime.setTimeUpdate(watchTime.getStoredTime() + timeInMilliseconds);
            int time = (int) (watchTime.getTimeUpdate() / 1000);

            int hours = time / 3600;

            int minutes = time / 60;
            for(;;) {
                if(minutes > 59) {
                    minutes -= 60;
                }
                else {
                    break;
                }
            }
            int seconds = time % 60;

            timeDisplay.setText(String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

            handler.postDelayed(this, 0);
        }
    };
    public void stopTimer(View view) {
        stopBtn.setEnabled(false);
        startBtn.setEnabled(true);
        resetBtn.setEnabled(true);

        watchTime.addStoredTime(timeInMilliseconds);

        handler.removeCallbacks(updateTimerRunnable);
    }
    public void resetTimer(View view) {
        stopBtn.setEnabled(false);
        resetBtn.setEnabled(false);

        watchTime.resetWatchTime();
        timeInMilliseconds = 0L;

        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        timeDisplay.setText(String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

        for(int i = 0; i < arrayList.size();) {
            arrayList.remove(0);
            adapter = new TimeStampAdapter(this, arrayList);
            listView.setAdapter(adapter);
        }
        commentText = "TAG";
    }
    public void timeStamp(View view) {
        int time = (int) (watchTime.getTimeUpdate() / 1000);

        int hours = time / 3600;
        int minutes = time / 60;

        for(;;) {
            if(minutes > 59) {
                minutes -= 60;
            }
            else {
                break;
            }
        }
        int seconds = time % 60;

        String currentTime = String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
        String comment = commentText;

        arrayList.add(new TimeStamp(currentTime, comment));
        adapter = new TimeStampAdapter(this, arrayList);
        listView.setAdapter(adapter);

        commentText = "TAG";
    }
    public void changeTag(View view) {
        if(view.getId() == R.id.comedyButton) {
            commentText = comedy;
        }
        else if(view.getId() == R.id.operationHealthButton) {
            commentText = opeationHealth;
        }
        else if(view.getId() == R.id.hacksButton) {
            commentText = hacks;
        }
        else if(view.getId() == R.id.rushButton) {
            commentText = rush;
        }
        else if(view.getId() == R.id.standardButton) {
            commentText = standard;
        }
        else if(view.getId() == R.id.aceButton) {
            commentText = ace;
        }
        else if(view.getId() == R.id.skillshotButton) {
            commentText = skillshot;
        }
        else if(view.getId() == R.id.hardScopeButton) {
            commentText = hardscope;
        }
        else if(view.getId() == R.id.vehicleSpreeButton) {
            commentText = vehicleSpree;
        }
        else if(view.getId() == R.id.cinematicButton) {
            commentText = cinematic;
        }
        else if(view.getId() == R.id.roadkillButton) {
            commentText = roadkill;
        }
        else if(view.getId() == R.id.longshotButton) {
            commentText = longshot;
        }
        else if(view.getId() == R.id.meleeButton) {
            commentText = melee;
        }
        else if(view.getId() == R.id.grenadeButton) {
            commentText = grenade;
        }
        else if(view.getId() == R.id.nubeTubeButton) {
            commentText = nubeTube;
        }
        else if(view.getId() == R.id.quickscopeButton) {
            commentText = quickscope;
        }
        else if(view.getId() == R.id.whipshotButton) {
            commentText = whipshot;
        }
        else if(view.getId() == R.id.precisionButton) {
            commentText = precision;
        }
        else{
            commentText = "ERROR";
        }
        timeStamp(view);
    }
    @Override
    public void onBackPressed() {
        //Go Away Back Button!
    }
}