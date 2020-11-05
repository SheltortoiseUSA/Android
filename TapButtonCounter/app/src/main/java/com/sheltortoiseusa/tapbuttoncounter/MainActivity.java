package com.sheltortoiseusa.tapbuttoncounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Counter count;
    private TextView countView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        count = new Counter();
        countView = (TextView) findViewById(R.id.textView);
    }
    public void countTap(View view) {
        count.addCount();
        countView.setText(count.getCount().toString());
    }
}
