package com.lamoureux.ccm2_td_android_insset.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "battery_table")
data class ObjectDataSample(
        val text: String,
        val image: String,
        val dateAjout: String
): Comparable<ObjectDataSample>, Cloneable
{
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
    override fun compareTo(other: ObjectDataSample): Int {
        return if (other.id == this.id && other.text == this.text && other.image == this.image && other.dateAjout == this.dateAjout) 0 else 1
    }
}