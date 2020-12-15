package com.lamoureux.ccm2_td_android_insset.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lamoureux.ccm2_td_android_insset.model.ObjectDataSample

@Dao
interface ObjectDataSampleDao {

    @Query("SELECT * FROM battery_table")
    fun selectAll(): LiveData<List<ObjectDataSample>>

    @Insert()
    fun insert(battery: ObjectDataSample)

    @Query("DELETE FROM battery_table")
    fun deleteAll()

    @Delete
    fun delete(battery: ObjectDataSample)
}
