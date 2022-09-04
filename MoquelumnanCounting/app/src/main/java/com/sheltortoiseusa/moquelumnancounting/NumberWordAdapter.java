package com.sheltortoiseusa.moquelumnancounting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class NumberWordAdapter extends ArrayAdapter<NumberWord> {

    public NumberWordAdapter(Activity context, ArrayList<NumberWord> wordList) {
        super(context, 0, wordList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NumberWord currentWord = getItem(position);

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView eName = (TextView) listItemView.findViewById(R.id.textView1);
        eName.setText(currentWord.eWord);

        TextView mName = (TextView) listItemView.findViewById(R.id.textView2);
        mName.setText(currentWord.mWord);

        ImageView num = (ImageView) listItemView.findViewById(R.id.imageView);
        num.setImageResource(currentWord.imageID);

        return listItemView;
    }
}