package com.sheltortoiseusa.hellogoodbye;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView greetingTextView;

    private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingTextView = (TextView) findViewById(R.id.textView);

        initializeGreeting();

        Button exclaimButton = (Button) findViewById(R.id.button);
        exclaimButton.setOnClickListener(toggleGreeting);
    }
    private void initializeGreeting() {
        isHello = true;
    }
    private final View.OnClickListener toggleGreeting = new View.OnClickListener() {
        public void onClick(View btn) {
            if(isHello) {
                isHello = false;

                greetingTextView.setText(R.string.goodbye);
            }
            else{
                isHello = true;

                greetingTextView.setText(R.string.hello);
            }
        }
    };
}
