package com.sheltortoiseusa.brewingbeer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GrainAdapter extends ArrayAdapter<Grain> {

    public GrainAdapter(Activity context, ArrayList<Grain> contactList) {
        super(context, 0, contactList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Grain currentGrain = getItem(position);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.grain_item, parent, false);
        }
        TextView name_text =(TextView) listItemView.findViewById(R.id.textView1);
        TextView weight_text =(TextView) listItemView.findViewById(R.id.textView2);
        TextView pps_text =(TextView) listItemView.findViewById(R.id.textView3);

        name_text.setText(currentGrain.grainName);
        weight_text.setText(currentGrain.pounds);
        pps_text.setText(currentGrain.pps);

        return listItemView;
    }
}