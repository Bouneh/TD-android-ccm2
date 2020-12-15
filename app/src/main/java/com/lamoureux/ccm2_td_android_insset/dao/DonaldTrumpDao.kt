package com.lamoureux.ccm2_td_android_insset.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump

@Dao
interface DonaldTrumpDao {

    @Query("SELECT * FROM donald_trump_quote_table")
    fun selectAll(): LiveData<List<DonaldTrump>>

    @Insert()
    fun insert(trump: DonaldTrump)

    @Query("DELETE FROM donald_trump_quote_table")
    fun deleteAll()

    @Delete
    fun delete(trump: DonaldTrump)
}
