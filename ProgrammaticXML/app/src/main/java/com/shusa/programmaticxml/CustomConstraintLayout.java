package com.shusa.programmaticxml;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class CustomConstraintLayout extends ConstraintLayout {
    public CustomConstraintLayout(final @NonNull Context CONTEXT) {
        super(CONTEXT);

        // Step 1: Set ID --> Set Bounds --> Apply Bounds to Layout --> Set Background Color (Optional)
        setId(View.generateViewId());
        final ViewGroup.LayoutParams LP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(LP);
        setBackgroundColor(getResources().getColor(R.color.purple_200));

        // Step 2: Link Constraint Set and Context
        final ConstraintSet CS = new ConstraintSet();
        CS.clone(this);


        // Step 3: Create and Link Children to Parent
        hardcoded2x2ButtonGrid(CONTEXT, CS);
        CS.applyTo(this);
    }

    private void hardcoded2x2ButtonGrid(final Context CONTEXT, final ConstraintSet CS) {
        // Create Buttons
        final Button B1 = new Button(CONTEXT);
        B1.setId(View.generateViewId());
        B1.setText("ONE");
        addView(B1);

        final Button B2 = new Button(CONTEXT);
        B2.setId(View.generateViewId());
        B2.setText("TWO");
        addView(B2);

        final Button B3 = new Button(CONTEXT);
        B3.setId(View.generateViewId());
        B3.setText("THREE");
        addView(B3);

        final Button B4 = new Button(CONTEXT);
        B4.setId(View.generateViewId());
        B4.setText("FOUR");
        addView(B4);

        // Set Button Bounds
        CS.constrainWidth(B1.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainHeight(B1.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainWidth(B2.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainHeight(B2.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainWidth(B3.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainHeight(B3.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainWidth(B4.getId(), ConstraintSet.WRAP_CONTENT);
        CS.constrainHeight(B4.getId(), ConstraintSet.WRAP_CONTENT);

        // Set Button Constraints
        CS.connect(B1.getId(), ConstraintSet.START,     ConstraintSet.PARENT_ID,    ConstraintSet.START);
        CS.connect(B1.getId(), ConstraintSet.END,       B2.getId(),                 ConstraintSet.START);
        CS.connect(B1.getId(), ConstraintSet.TOP,       ConstraintSet.PARENT_ID,    ConstraintSet.TOP);
        CS.connect(B1.getId(), ConstraintSet.BOTTOM,    B3.getId(),                 ConstraintSet.TOP);


        CS.connect(B2.getId(), ConstraintSet.START,     B1.getId(),                 ConstraintSet.END);
        CS.connect(B2.getId(), ConstraintSet.END,       ConstraintSet.PARENT_ID,    ConstraintSet.END);
        CS.connect(B2.getId(), ConstraintSet.TOP,       B1.getId(),                 ConstraintSet.TOP);
        CS.connect(B2.getId(), ConstraintSet.BOTTOM,    B1.getId(),                 ConstraintSet.BOTTOM);


        CS.connect(B3.getId(), ConstraintSet.START,     ConstraintSet.PARENT_ID,    ConstraintSet.START);
        CS.connect(B3.getId(), ConstraintSet.END,       B4.getId(),                 ConstraintSet.START);
        CS.connect(B3.getId(), ConstraintSet.TOP,       B1.getId(),                 ConstraintSet.BOTTOM);
        CS.connect(B3.getId(), ConstraintSet.BOTTOM,    ConstraintSet.PARENT_ID,    ConstraintSet.BOTTOM);


        CS.connect(B4.getId(), ConstraintSet.START,     B3.getId(),                 ConstraintSet.END);
        CS.connect(B4.getId(), ConstraintSet.END,       ConstraintSet.PARENT_ID,    ConstraintSet.END);
        CS.connect(B4.getId(), ConstraintSet.TOP,       B3.getId(),                 ConstraintSet.TOP);
        CS.connect(B4.getId(), ConstraintSet.BOTTOM,    B3.getId(),                 ConstraintSet.BOTTOM);
    }
}
