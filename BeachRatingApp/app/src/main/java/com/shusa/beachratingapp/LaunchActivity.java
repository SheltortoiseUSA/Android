package com.shusa.beachratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {
    private final String CLASS_TAG = this.getClass().getSimpleName();
    private final Context CONTEXT = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Log.i(CLASS_TAG, String.valueOf(R.string.log_entered_function));

        // Initialize Local Variables
        TextView continueTV = findViewById(R.id.launch_continue_tv);
        continueTV.setOnClickListener(progressToLogin);
    }

    // Progress UI to Login Screen
    private final View.OnClickListener progressToLogin = VIEW -> {
        Log.i(CLASS_TAG, String.valueOf(R.string.log_exiting_function));

        final Intent INTENT = new Intent(CONTEXT, LoginActivity.class);
        startActivity(INTENT);
    };
}