package com.lamoureux.ccm2_td_android_insset.repository

import androidx.lifecycle.LiveData
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener.Builder.withContext
import com.lamoureux.ccm2_td_android_insset.architecture.CustomApplication
import com.lamoureux.ccm2_td_android_insset.model.ObjectDataSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BatteryRepository {
    private val mBatteryDao = CustomApplication.instance.mApplicationDatabase.mBatteryDao()

    fun selectAllBattery() : LiveData<List<ObjectDataSample>> {
        return mBatteryDao.selectAll()
    }

    suspend fun insertBattery(battery: ObjectDataSample) = withContext(Dispatchers.IO) {
        mBatteryDao.insert(battery)
    }

    suspend fun deleteAllBattery() = withContext(Dispatchers.IO) {
        mBatteryDao.deleteAll()
    }

    fun deleteBattery(battery: ObjectDataSample) {
        mBatteryDao.delete(battery)
    }
}
