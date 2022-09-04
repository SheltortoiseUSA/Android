package com.shusa.beachratingapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    private final String CLASS_TAG = this.getClass().getSimpleName();
    private final Context CONTEXT = this;

    private TabLayout loginTabFLO;

    private Fragment existingAccFrag;
    private Fragment newAccFrag;

    private int chosenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(CLASS_TAG, String.valueOf(R.string.log_entered_function));

        // Initialize Global Variables
        loginTabFLO = (TabLayout) findViewById(R.id.tab_widget_tlo);
        existingAccFrag = new ExistingAccountFragment();
        newAccFrag = new NewAccountFragment();

        // Switch Login Tab Fragment Based on Selected Tab
        loginTabFLO.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (loginTabFLO.getSelectedTabPosition() == 0) {
                    chosenFragment = 1;
                    inflateAccountTab(existingAccFrag);
                    Log.i(CLASS_TAG, "existingAccountFragment Inflated");
                } else if (loginTabFLO.getSelectedTabPosition() == 1) {
                    chosenFragment = 2;
                    inflateAccountTab(newAccFrag);
                    Log.i(CLASS_TAG, "existingAccountFragment Inflated");
                } else {
                    Log.e(CLASS_TAG, "No Tab Found");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (loginTabFLO.getSelectedTabPosition() == 0) {
                    deflateAccountTab(newAccFrag);
                    Log.i(CLASS_TAG, "NewAccountFragment Inflated");
                } else if (loginTabFLO.getSelectedTabPosition() == 1) {
                    deflateAccountTab(existingAccFrag);
                    Log.i(CLASS_TAG, "existingAccountFragment Deflated");
                } else {
                    Log.e(CLASS_TAG, "No Tab Found");
                }
                chosenFragment = 0;
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Do Nothing
            }
        });

        // Start with ExistingAccountTab Inflated
        inflateAccountTab(existingAccFrag);
    }

    // Add Login Tab Fragment
    public void inflateAccountTab(final Fragment INPUT_FRAG) {
        final FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.add(R.id.login_tab_flo, INPUT_FRAG);
        FT.commit();

        Log.i(CLASS_TAG, INPUT_FRAG.toString() + R.string.log_was_inflated_blerb);
    }

    // Remove Login Tab Fragment
    public void deflateAccountTab(final Fragment INPUT_FRAG) {
        final FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.remove(INPUT_FRAG);
        FT.commit();

        Log.i(CLASS_TAG, INPUT_FRAG.toString() + R.string.log_was_deflated_blerb);
    }

    // Cleanup Remaining Open Fragment
    public void cleanupOpenFragment() {
        if (chosenFragment == 1) {
            deflateAccountTab(existingAccFrag);
            Log.i(CLASS_TAG, String.valueOf(R.string.log_existing_account_frag_deflated));
        } else if (chosenFragment == 2) {
            deflateAccountTab(newAccFrag);
            Log.i(CLASS_TAG, String.valueOf(R.string.log_new_account_frag_deflated));
        } else {
            Log.e(CLASS_TAG, String.valueOf(R.string.log_no_frag_to_destroy));
        }
    }

    @Override
    public void onBackPressed() {
        // Disable the Android back button, so the User cannot backtrack.
        Toast.makeText(CONTEXT, R.string.msg_back_button_unavailable, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        Log.i(CLASS_TAG, String.valueOf(R.string.log_exiting_function));

        // Ensure that the open fragment is closed.
        cleanupOpenFragment();
        super.onDestroy();
    }
}