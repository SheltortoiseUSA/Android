package com.sheltortoiseusa.contacts;

import android.app.Activity;

public class Contact extends Activity {
    // Public Data Members
    public String name;
    public String relationship;
    public int photoId;

    // Explicit Constructor
    public Contact(String n, String r, int i) {
        name = n;
        relationship = r;
        photoId = i;
    }
    public Contact(String n, int i) {
        name = n;
        relationship = "";
        photoId = i;
    }
}