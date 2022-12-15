package com.shusa.beachratingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.ViewHolder> {
    // Data Members
    Context context;
    ArrayList<Beach> beaches;

    // Explicit Constructor
    public BeachAdapter(Context CONTEXT, final ArrayList<Beach> BEACHES) {
        context = CONTEXT;
        beaches = BEACHES;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater LI = LayoutInflater.from(context);
        final View VIEW = LI.inflate(R.layout.item_beach, parent, false);
        return new ViewHolder(VIEW);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.beachNameTV.setText(beaches.get(position).name);
        holder.publicBeachRatingTV.setText(beaches.get(position).displayRating);
        holder.beachPictureIV.setImageResource(beaches.get(position).imageLocation);
        holder.personalBeachRatingRB.setRating(beaches.get(position).personalRating);
    }

    @Override
    public int getItemCount() {
        return beaches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView beachNameTV;
        TextView publicBeachRatingTV;
        ImageView beachPictureIV;
        RatingBar personalBeachRatingRB;

        public ViewHolder(@NonNull final View ITEM_VIEW) {
            super(ITEM_VIEW);
            beachNameTV = ITEM_VIEW.findViewById(R.id.beach_title_tv);
            publicBeachRatingTV = ITEM_VIEW.findViewById(R.id.beach_public_rating_tv);
            beachPictureIV = ITEM_VIEW.findViewById(R.id.beach_picture_iv);
            personalBeachRatingRB = ITEM_VIEW.findViewById(R.id.beach_personal_rating_rb);
        }
    }
}
