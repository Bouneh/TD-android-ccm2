package com.lamoureux.ccm2_td_android_insset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lamoureux.ccm2_td_android_insset.model.DonaldTrump
import com.lamoureux.ccm2_td_android_insset.view.DonaldTrumpViewModel
import com.lamoureux.ccm2_td_android_insset.view.adapter.DonaldTrumpQuoteAdapter
import kotlinx.android.synthetic.main.activity_retrofit.*

class Retrofit : AppCompatActivity() {
    // We need variable of our adapter
    private lateinit var mAdapter: DonaldTrumpQuoteAdapter
    private lateinit var mViewModel: DonaldTrumpViewModel
    private var mObserverAndroidVersion = Observer<List<DonaldTrump>> {
        updateRecyclerView(ArrayList(it))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mViewModel = ViewModelProvider(this)[DonaldTrumpViewModel::class.java]
        // Create the instance of adapter
        mAdapter = DonaldTrumpQuoteAdapter(this)
        // We define the style
        itemRecyclerViewQuote.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        // We set the adapter to recycler view
        itemRecyclerViewQuote.adapter = mAdapter


        btnAddQuote.setOnClickListener { addRandomAndroidVersion() }
        btnDeleteQuote.setOnClickListener { deleteAndroidVersion() }
    }

    override fun onStart() {
        super.onStart()
        mViewModel.mDonaldTrumpQuoteLiveData.observe(this, mObserverAndroidVersion)
    }


    override fun onStop() {
        mViewModel.mDonaldTrumpQuoteLiveData.removeObserver(mObserverAndroidVersion)
        super.onStop()
    }


    private fun updateRecyclerView(newList: ArrayList<DonaldTrump>) {
        mAdapter.rebuild(newList)
    }


    private fun addRandomAndroidVersion() {
        mViewModel.fetchNewQuote()
    }


    private fun deleteAndroidVersion() {
        mViewModel.deleteAllQuote()
    }
}