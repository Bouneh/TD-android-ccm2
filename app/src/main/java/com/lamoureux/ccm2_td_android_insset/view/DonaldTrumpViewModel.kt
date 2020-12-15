package com.lamoureux.ccm2_td_android_insset.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump
import com.lamoureux.ccm2_td_android_insset.repository.DonaldTrumpRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DonaldTrumpViewModel : ViewModel() {


    private val mDonaldTrumpQuoteRepository: DonaldTrumpRepository by lazy { DonaldTrumpRepository() }
    var mDonaldTrumpQuoteLiveData: LiveData<List<DonaldTrump>> = mDonaldTrumpQuoteRepository.selectAllDonaldTrump()


    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mDonaldTrumpQuoteRepository.fetchData()
        }
    }


    fun deleteAllQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            mDonaldTrumpQuoteRepository.deleteAllDonaldTrump()
        }
    }
}
