package com.lamoureux.ccm2_td_android_insset.view

import androidx.recyclerview.widget.DiffUtil
import com.lamoureux.ccm2_td_android_insset.model.ObjectDataSample

class BatteryDiffUtil(
        private val newList: ArrayList<ObjectDataSample>?,
        private val oldList: ArrayList<ObjectDataSample>?
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }


    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList!![newItemPosition].id == oldList!![oldItemPosition].id
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val result = newList!![newItemPosition].compareTo(oldList!![oldItemPosition])
        return result == 0
    }
}