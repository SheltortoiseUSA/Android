package com.sheltortoiseusa.moquelumnancounting;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final ArrayList<NumberWord> words = new ArrayList<NumberWord>();
        words.add(new NumberWord("One", "1", R.drawable.number_one, R.raw.number_one));
        words.add(new NumberWord("Two", "2", R.drawable.number_two, R.raw.number_two));
        words.add(new NumberWord("Three", "3", R.drawable.number_three, R.raw.number_three));
        words.add(new NumberWord("Four", "4", R.drawable.number_four, R.raw.number_four));
        words.add(new NumberWord("Five", "5", R.drawable.number_five, R.raw.number_five));
        words.add(new NumberWord("Six", "6", R.drawable.number_six, R.raw.number_six));
        words.add(new NumberWord("Seven", "7", R.drawable.number_seven, R.raw.number_seven));
        words.add(new NumberWord("Eight", "8", R.drawable.number_eight, R.raw.number_eight));
        words.add(new NumberWord("Nine", "9", R.drawable.number_nine, R.raw.number_nine));
        words.add(new NumberWord("Ten", "10", R.drawable.number_ten, R.raw.number_ten));

        NumberWordAdapter itemsAdapter = new NumberWordAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.activity_my);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mMediaPlayer = MediaPlayer.create(MyActivity.this, words.get(position).audioID);
                mMediaPlayer.start();
            }
        });
    }
}