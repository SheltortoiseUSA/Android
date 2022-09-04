package com.sheltortoiseusa.brewingbeer;

import android.support.v7.app.AppCompatActivity;

public class Grain extends AppCompatActivity {
    public String grainName;
    public String pounds;
    public String pps;

    public Grain(String grain, String lbs, String tempPPS) {
        grainName = grain;
        pounds = "lbs " + lbs;
        pps = "PPS " + tempPPS;
    }
}