package com.sheltortoiseusa.fibonacciflower;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MyActivity extends Activity {
    private ArrayList<ImageView> allPetals;

    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;

    private Button pinkBtn;
    private Button goldBtn;
    private Button clearBtn;

    Flower myFlower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myFlower = new Flower();
        allPetals = new ArrayList<ImageView>();

        initialize();

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);

        pinkBtn = (Button) findViewById(R.id.button1);
        goldBtn = (Button) findViewById(R.id.button2);
        clearBtn = (Button) findViewById(R.id.button3);;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        myFlower.set_xCenter(metrics.widthPixels / 2);
        myFlower.set_yCenter(metrics.heightPixels / 2);
    }
    private void initialize() {
        myFlower.setRotate(0);

        myFlower.setScaleX((float) .3);
        myFlower.setScaleY((float) .3);

        myFlower.setDegenerate((float) 1.001);

        myFlower.initializeAngle();
    }

    public void addPetal(View view) {
        ImageView petal;

        String buttonText = ((Button) view).getText().toString();

        if(buttonText.equals("Add Pink")) {
            petal=(ImageView) layoutInflater.inflate(R.layout.petal_pink,null);
        }
        else {
            petal=(ImageView) layoutInflater.inflate(R.layout.petal_gold,null);
        }
        petal.setX(myFlower.get_xCenter());
        petal.setY(myFlower.get_yCenter());

        petal.setPivotY(0);
        petal.setPivotX(100);

        petal.setScaleX(myFlower.getScaleX());
        petal.setScaleY(myFlower.getScaleY());

        petal.setRotation(myFlower.getRotate());

        relativeLayout.addView(petal,0);
        allPetals.add(petal);

        myFlower.updatePetalValues();
    }
    public void clearPetals(View view) {
        for(int i = 0; i < allPetals.size(); i++) {
            ImageView petal = allPetals.get(i);
            relativeLayout.removeView(petal);
        }
        allPetals.clear();
        initialize();
    }
}