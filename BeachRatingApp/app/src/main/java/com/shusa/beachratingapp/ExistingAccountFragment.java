package com.shusa.beachratingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class ExistingAccountFragment extends Fragment {
    private final String CLASS_TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(final LayoutInflater LI, final ViewGroup CONTAINER, final Bundle SAVED_INSTANCE_STATE) {
        Log.i(CLASS_TAG, String.valueOf(R.string.log_entered_function));

        final View ROOT_VIEW = LI.inflate(R.layout.fragment_existing_account, CONTAINER, false);
        final Button CONFIRMATION_BUTTON = ROOT_VIEW.findViewById(R.id.existing_account_confirmation_btn);
        CONFIRMATION_BUTTON.setOnClickListener(progressToHome);

        return ROOT_VIEW;
    }

    // Progress UI to Home Screen
    private final View.OnClickListener progressToHome = VIEW -> {
        Log.i(CLASS_TAG, String.valueOf(R.string.log_exiting_function));

        final Intent INTENT = new Intent(getActivity(), HomeActivity.class);
        startActivity(INTENT);
    };
}