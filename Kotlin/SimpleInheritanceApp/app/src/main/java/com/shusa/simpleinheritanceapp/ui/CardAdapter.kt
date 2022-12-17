package com.shusa.simpleinheritanceapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shusa.simpleinheritanceapp.R
import com.shusa.simpleinheritanceapp.data.CardsViewModel

class CardAdapter(private val cards: List<CardsViewModel>) : RecyclerView.Adapter<CardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_inheritor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardsViewModel = cards[position]

        holder.cardName.text = cardsViewModel._name.toString()
        holder.cardShares.text = cardsViewModel._shares.toString()
        holder.cardInheritance.text = cardsViewModel._inheritance.toString()
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    class ViewHolder(card: View) : RecyclerView.ViewHolder(card) {
        val cardName: TextView = itemView.findViewById(R.id.card_name_tv)
        val cardShares: TextView = itemView.findViewById(R.id.card_amount_of_shares_tv)
        val cardInheritance: TextView = itemView.findViewById(R.id.card_inheritance_tv)
    }
}