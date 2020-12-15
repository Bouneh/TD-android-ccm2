package com.lamoureux.ccm2_td_android_insset.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "donald_trump_quote_table")
data class DonaldTrump(
        @Expose
        @SerializedName("value")
        val quote: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
