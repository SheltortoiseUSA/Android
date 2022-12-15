package com.sheltortoiseusa.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        ArrayList<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact("Jake", R.drawable.male1));
        contactList.add(new Contact("Besse", R.drawable.male1));
        contactList.add(new Contact("Zach", R.drawable.male2));
        contactList.add(new Contact("Jordan", R.drawable.male3));
        contactList.add(new Contact("Jordan", R.drawable.male4));
        contactList.add(new Contact("Greg", R.drawable.male3));
        contactList.add(new Contact("George", R.drawable.male2));
        contactList.add(new Contact("John", R.drawable.male2));
        contactList.add(new Contact("Jeff", R.drawable.male1));

        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        for(int i = 0; i < contactList.size(); i++) {
            LinearLayout myContactItem = (LinearLayout) LayoutInflater.from(getBaseContext()).inflate(R.layout.contact_item, null);

            TextView name_text = (TextView) myContactItem.findViewById(R.id.textView1);
            TextView relationship_text = (TextView) myContactItem.findViewById(R.id.textView2);
            ImageView photo_image = (ImageView) myContactItem.findViewById(R.id.imageView);

            name_text.setText(contactList.get(i).name);
            relationship_text.setText(contactList.get(i).relationship);
            photo_image.setImageResource(contactList.get(i).photoId);

            rootView.addView(myContactItem);
        }
    }
}