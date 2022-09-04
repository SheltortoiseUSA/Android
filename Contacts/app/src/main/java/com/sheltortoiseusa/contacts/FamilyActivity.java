package com.sheltortoiseusa.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact("Tom Shelter", "Dad", R.drawable.male1));
        contactList.add(new Contact("Geoffery Shelter", "Brother", R.drawable.male2));
        contactList.add(new Contact("Kristoffer Shelter", "Brother", R.drawable.male3));
        contactList.add(new Contact("Jason Shelter", "Uncle", R.drawable.male4));
        contactList.add(new Contact("Mark Gummienney", "Uncle", R.drawable.male5));

        ListView rootView = (ListView)findViewById(R.id.rootView);

        ContactsAdapter itemsAdapter = new ContactsAdapter(this, contactList);
        rootView.setAdapter(itemsAdapter);
    }
}