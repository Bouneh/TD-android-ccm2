package com.lamoureux.ccm2_td_android_insset.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lamoureux.ccm2_td_android_insset.R
import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump

class DonaldTrumpQuoteAdapter(private val context : Context) : RecyclerView.Adapter<DonaldTrumpQuoteAdapter.StarWardQuoteViewHolder>() {


    // Create list of data we want to display in list as var of class
    private val mStarWarsQuote = ArrayList<DonaldTrump>()

    // Needed to get the item_layout
    private val mInflater: LayoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWardQuoteViewHolder {
        // This line perform the matching with our ViewHolder and the item from layout
        return StarWardQuoteViewHolder(mInflater.inflate(R.layout.item_custom_recycler, parent, false))
    }


    override fun getItemCount(): Int = mStarWarsQuote.size


    override fun onBindViewHolder(holder: StarWardQuoteViewHolder, position: Int) {
        // onBindViewHolder is called for each item we want to display so we need to get each object
        val currentItem = mStarWarsQuote[position]


        holder.itemRecyclerViewVersionName.text = currentItem.quote
    }

    fun rebuild(DonaldTrumpQuote : ArrayList<DonaldTrump>) {
        // This is the simplest way to update the list
        mStarWarsQuote.clear()
        mStarWarsQuote.addAll(DonaldTrumpQuote)
        // Needed to said to recycler view we have new data
        this.notifyDataSetChanged()
    }


    /**
     * Internal class
     */


    inner class StarWardQuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemRecyclerViewVersionName: TextView = itemView.findViewById(R.id.textQuoteDonaldTrump)
    }
}
