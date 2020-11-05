package com.sheltortoiseusa.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AcquaintancesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquaintances);

        ArrayList<String> contactList = new ArrayList<String>();
        contactList.add("Grant Gardner");
        contactList.add("Branden ALlen");
        contactList.add("Alec Besse");
        contactList.add("Zachary Landacaster");
        contactList.add("Micheal Sevilla");
        contactList.add("Anthony Hernandez");
        contactList.add("Jordan Davis");
        contactList.add("Brennon");
        contactList.add("Kevin");
        contactList.add("Jake");
        contactList.add("Tristin");

        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        for(int i = 0; i < contactList.size(); i++) {
            LinearLayout myContactItem = (LinearLayout) LayoutInflater.from(getBaseContext()).inflate(R.layout.contact_item, null);

            TextView name_text = (TextView) myContactItem.findViewById(R.id.textView1);
            TextView relationship_text = (TextView) myContactItem.findViewById(R.id.textView2);
            ImageView photo_image = (ImageView) myContactItem.findViewById(R.id.imageView);

            name_text.setText(contactList.get(i));
            relationship_text.setText(" ");
            photo_image.setImageResource(R.drawable.male2);

            rootView.addView(myContactItem);
        }
    }
}
