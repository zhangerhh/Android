package com.example.myapplication_final.ui.card

import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication4.model.CardMatchingGame
import com.example.myapplication_final.R

class CardAdapter(val game:CardMatchingGame):RecyclerView.Adapter<CardAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val  cardButton: Button
        init {
            cardButton = itemView.findViewById(R.id.button)
        }
    }

    var mListener: ((Int)->Unit)? = null
    fun setOnClickListener(l:(Int)->Unit){
        mListener = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return game.cards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = game.cardAtIndex(position)
        holder.cardButton.isEnabled = !card.isMatched
        if (card.isChosen) {
            holder.cardButton.text = card.toString()
            holder.cardButton.setBackgroundColor(Color.WHITE)
        } else {
            holder.cardButton.text = ""
            holder.cardButton.setBackgroundResource(R.drawable.sicnu)
        }
        holder.cardButton.setOnClickListener {
            mListener?.invoke(position)
        }
    }
}