package com.shusa.programmaticrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {
    ArrayList<String> textList;

    public TextAdapter(final ArrayList<String> LIST) {
        textList = LIST;
    }

    @NonNull
    @Override
    public TextAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View VIEW = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(VIEW);
    }

    @Override
    public void onBindViewHolder(final @NonNull TextAdapter.ViewHolder HOLDER, final int POS) {
        HOLDER.nameTV.setText(textList.get(POS));
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTV;

        public ViewHolder(final View IV) {
            super(IV);

            nameTV = IV.findViewById(R.id.full_name);
        }
    }
}
