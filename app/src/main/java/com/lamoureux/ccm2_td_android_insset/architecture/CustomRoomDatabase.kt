package com.lamoureux.ccm2_td_android_insset.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lamoureux.ccm2_td_android_insset.dao.DonaldTrumpDao
import com.lamoureux.ccm2_td_android_insset.dao.ObjectDataSampleDao
import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump
import com.lamoureux.ccm2_td_android_insset.model.ObjectDataSample

@Database(
        entities = [
            ObjectDataSample::class,
            DonaldTrump::class,
        ],
        version = 1,
        exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun mBatteryDao(): ObjectDataSampleDao
    abstract fun mDonaldTrumpDao(): DonaldTrumpDao
}
