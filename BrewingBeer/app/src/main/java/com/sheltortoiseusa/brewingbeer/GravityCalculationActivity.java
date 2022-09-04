package com.sheltortoiseusa.brewingbeer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class GravityCalculationActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gravity_calculation_activity);

        textView = (TextView) findViewById(R.id.textView1);
    }
    public void doMath(ArrayList<Grain> grainList) {
        double total = 0;
        for(int i = 0; i < grainList.size(); i++) {
            Grain grain = grainList.get(i);

            Double weight = Double.parseDouble(grain.pounds);
            Double pps = Double.parseDouble(grain.pps);
            if(weight > .00001 && pps > .00001) {
                total += (((weight * pps) / 5.5) / 1000) + 1;
            }
        }
        String pps = Double.toString(total);
        String ppsStatement = ("Estimated Specific Gravity: " + pps + "/n"
                + "(Assumes a 5.5 gallon batch");
        textView.setText(ppsStatement);
    }
}