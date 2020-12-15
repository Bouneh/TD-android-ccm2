package com.lamoureux.ccm2_td_android_insset

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lamoureux.ccm2_td_android_insset.model.BatteryViewModel
import com.lamoureux.ccm2_td_android_insset.model.ObjectDataSample
import com.lamoureux.ccm2_td_android_insset.view.BatteryDiffUtil

class AndroidVersionAdapter(private val context : Context) : RecyclerView.Adapter<AndroidVersionAdapter.AndroidVersionViewHolder>() {

    private val mAndroidListVersion = ArrayList<ObjectDataSample>()

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var viewModel = BatteryViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        // This line perform the matching with our ViewHolder and the item from layout
        return AndroidVersionViewHolder(mInflater.inflate(R.layout.item_custom_recycler, parent, false))
    }


    override fun getItemCount(): Int  = mAndroidListVersion.size


    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        // onBindViewHolder is called for each item we want to display so we need to get each object
        val currentItem = mAndroidListVersion[position]
        // Set the value of our POJO for each item
        holder.itemRecyclerViewVersionText.text = currentItem.text

        Glide.with(context)
                .load(currentItem.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.itemRecyclerViewVersionImage)
    }

    fun rebuild(BatteryList : ArrayList<ObjectDataSample>) {
        val diffUtil = DiffUtil.calculateDiff(BatteryDiffUtil(BatteryList, this.mAndroidListVersion))
        mAndroidListVersion.clear()
        mAndroidListVersion.addAll(BatteryList)
        diffUtil.dispatchUpdatesTo(this)
    }


    inner class AndroidVersionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val itemRecyclerViewVersionText: TextView = itemView.findViewById(R.id.textQuoteDonaldTrump)
        val itemRecyclerViewVersionImage: ImageView = itemView.findViewById(R.id.imageView)
    }

}
