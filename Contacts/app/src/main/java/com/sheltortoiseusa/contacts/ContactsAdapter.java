package com.sheltortoiseusa.contacts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactsAdapter extends ArrayAdapter<Contact> {

    public ContactsAdapter(Activity context, ArrayList<Contact> contactList) {
        // Context, Container, ContactList.
        super(context, 0, contactList);
    }
    @Override
    // Same parameters as in the super getView(...)
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact currentContact = getItem(position);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);
        }
        TextView name_text = (TextView) listItemView.findViewById(R.id.textView1);
        TextView relationship_text = (TextView) listItemView.findViewById(R.id.textView2);
        ImageView photo_image = (ImageView) listItemView.findViewById(R.id.imageView);

        name_text.setText(currentContact.name);
        relationship_text.setText(currentContact.relationship);
        photo_image.setImageResource(currentContact.photoId);

        return listItemView;
    }
}