package com.sheltortoiseusa.timestamper;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TimeStampAdapter extends ArrayAdapter<TimeStamp> {

    public TimeStampAdapter(Activity context, ArrayList<TimeStamp> timeStampList) {
        super(context, 0, timeStampList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TimeStamp currentTimeStamp = getItem(position);

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.time_stamp_item, parent, false);
        }
        TextView time_stamp_text = (TextView) listItemView.findViewById(R.id.timeStamp);
        TextView comment_text = (TextView) listItemView.findViewById(R.id.comment);

        time_stamp_text.setText(currentTimeStamp.timeStamp);
        comment_text.setText(currentTimeStamp.comment);

        return listItemView;
    }
}