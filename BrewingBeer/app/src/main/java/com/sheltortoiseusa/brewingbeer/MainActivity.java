package com.sheltortoiseusa.brewingbeer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout textViews;
    private LinearLayout editTexts;

    private EditText et1;
    private EditText et2;
    private EditText et3;

    private Button multiPurposeBtn;
    private Button computeSGBtn;
    private Button clearAllBtn;

    private TextView textView;

    private ArrayList<Grain> grainList = new ArrayList<Grain>();

    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViews = (LinearLayout) findViewById(R.id.TextViewLayout);
        editTexts = (LinearLayout) findViewById(R.id.EditTextLayout);

        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);

        multiPurposeBtn = (Button) findViewById(R.id.button1);
        computeSGBtn = (Button) findViewById(R.id.button2);
        clearAllBtn = (Button) findViewById(R.id.button3);

        textView = (TextView) findViewById(R.id.textView1);

        textViews.setAlpha(0);
        editTexts.setAlpha(0);
    }
    public void addGrain(View view) {
        if(multiPurposeBtn.getText().charAt(0) == 'A') {
            textViews.setAlpha(1);
            editTexts.setAlpha(1);
            computeSGBtn.setAlpha(0);
            clearAllBtn.setAlpha(0);

            multiPurposeBtn.setText(R.string.submit_new_grain_item_btn);
        }
        else if(multiPurposeBtn.getText().charAt(0) == 'S'){
            submitNewGrainItem(view);
            textViews.setAlpha(0);
            editTexts.setAlpha(0);
            computeSGBtn.setAlpha(1);
            clearAllBtn.setAlpha(1);

            multiPurposeBtn.setText(R.string.add_grain_btn);
        }
    }
    public void submitNewGrainItem(View view) {
        grainList.add(new Grain(et1.getText().toString(), et2.getText().toString(), et3.getText().toString()));

        ListView rootView = (ListView)findViewById(R.id.rootView);

        GrainAdapter itemsAdapter = new GrainAdapter(this, grainList);
        rootView.setAdapter(itemsAdapter);
    }
    public void computeSG(View view) {
        //Trish: The below statement would not execute... could not figure out why.
        //GravityCalculationActivity.doMath(grainList);

        Intent intent = new Intent(this, GravityCalculationActivity.class);
        startActivity(intent);
    }
    //Trish: The below code can only remove one item at a time until 2 remain, then nothing happens.
    public void clearAll(View view) {
        for(int i = 0; i < grainList.size(); i++) {
            grainList.remove(i);
        }
        submitNewGrainItem(view);
    }
}