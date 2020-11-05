package com.sheltortoiseusa.happytosad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView moodView;
    private ImageView emojiView;

    private boolean isHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_interface);

        moodView = (TextView) findViewById(R.id.textView1);
        emojiView = (ImageView) findViewById(R.id.imageView1);
    }
    public void changeViews(View view) {
        if(isHappy == true) {
            isHappy = false;
            moodView.setText(R.string.sad_emoji);
            emojiView.setImageResource(R.drawable.sad_face);
        }
        else {
            isHappy = true;
            moodView.setText(R.string.happy_emoji);
            emojiView.setImageResource(R.drawable.happy_face);
        }
    }
}
