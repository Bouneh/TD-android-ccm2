package com.lamoureux.ccm2_td_android_insset.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lamoureux.ccm2_td_android_insset.repository.BatteryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BatteryViewModel : ViewModel() {

    private val mBatteryRepository: BatteryRepository by lazy { BatteryRepository() }
    var mBatteryLiveData: LiveData<List<ObjectDataSample>> = mBatteryRepository.selectAllBattery()

    fun insertBattery(pourcentage: String, image: String, dateAjout: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mBatteryRepository.insertBattery(
                    ObjectDataSample(pourcentage, image, dateAjout)
            )
        }
    }

    fun deleteAllBattery() {
        viewModelScope.launch(Dispatchers.IO) {
            mBatteryRepository.deleteAllBattery()
        }
    }

    fun deleteBattery(battery: ObjectDataSample) {
        viewModelScope.launch(Dispatchers.IO) {
            mBatteryRepository.deleteBattery(battery)
        }
    }
}