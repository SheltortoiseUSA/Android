package com.shusa.programmaticxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomConstraintLayout customCLO = new CustomConstraintLayout(this);
        setContentView(customCLO);
    }
}