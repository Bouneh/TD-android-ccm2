package com.lamoureux.ccm2_td_android_insset.repository

import androidx.lifecycle.LiveData
import com.lamoureux.ccm2_td_android_insset.architecture.CustomApplication
import com.lamoureux.ccm2_td_android_insset.architecture.RetrofitBuilder
import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DonaldTrumpRepository {
    private val mDonaldTrumpDao = CustomApplication.instance.mApplicationDatabase.mDonaldTrumpDao()


    fun selectAllDonaldTrump() : LiveData<List<DonaldTrump>> {
        return mDonaldTrumpDao.selectAll()
    }


    private suspend fun insertDonaldTrump(DonaldTrump: DonaldTrump) = withContext(Dispatchers.IO) {
        mDonaldTrumpDao.insert(DonaldTrump)
    }


    suspend fun deleteAllDonaldTrump() = withContext(Dispatchers.IO) {
        mDonaldTrumpDao.deleteAll()
    }


    suspend fun fetchData() {
        insertDonaldTrump(RetrofitBuilder.getDonaldTrump().getRandomQuote())
    }

}