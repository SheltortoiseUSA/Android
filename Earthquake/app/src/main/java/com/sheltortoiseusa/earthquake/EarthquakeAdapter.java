package com.sheltortoiseusa.earthquake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter (Activity context, ArrayList<Earthquake> earthquakeList) {
        super (context, 0, earthquakeList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earthquake currentQuake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.textView1);
        magTextView.setText(currentQuake.mag);

        TextView cityTextView = (TextView) listItemView.findViewById(R.id.textView2);
        cityTextView.setText(currentQuake.city);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.textView3);
        dateTextView.setText(currentQuake.mDate);

        return listItemView;
    }
}