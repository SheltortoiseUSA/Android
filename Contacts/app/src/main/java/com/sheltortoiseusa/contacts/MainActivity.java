package com.sheltortoiseusa.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_interface);
    }
    public void openFriendsList(View view) {
        Intent intent = new Intent(this, FriendsActivity.class);
        startActivity(intent);
    }
    public void openFamilyList(View view) {
        Intent intent = new Intent(this, FamilyActivity.class);
        startActivity(intent);
    }
    public void openProfessionalList(View view) {
        Intent intent = new Intent(this, ProfessionalActivity.class);
        startActivity(intent);
    }
    public void openAcquaintancesList(View view) {
        Intent intent = new Intent(this, AcquaintancesActivity.class);
        startActivity(intent);
    }
}
