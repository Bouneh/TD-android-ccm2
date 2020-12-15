package com.lamoureux.ccm2_td_android_insset

import android.os.Build
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.lamoureux.ccm2_td_android_insset.AndroidVersionAdapter
import com.lamoureux.ccm2_td_android_insset.model.BatteryViewModel
import com.lamoureux.ccm2_td_android_insset.model.ObjectDataSample
import kotlinx.android.synthetic.main.activity_recycler_view.*
import java.time.LocalDateTime
import kotlin.collections.ArrayList
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {


    // We need variable of our adapter
    private lateinit var mAdapter: AndroidVersionAdapter

    private var viewModel = BatteryViewModel()
    private var observerMyData = Observer<List<ObjectDataSample>> {
        updateRecyclerView(ArrayList(it))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        viewModel = ViewModelProvider(this)[BatteryViewModel::class.java]

        // Create the instance of adapter
        mAdapter = AndroidVersionAdapter(this)

        itemRecyclerViewImage.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // We set the adapter to recycler view
        itemRecyclerViewImage.adapter = mAdapter

        btnAdd.setOnClickListener {
            add()
        }
        btnDelete.setOnClickListener { deleteAll() }
    }

    private fun deleteAll() {
        viewModel.deleteAllBattery()
    }

    private fun updateRecyclerView(data: ArrayList<ObjectDataSample>) {
        mAdapter.rebuild(data)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun add(){
        val random = Random.nextInt(0, 1000)
        val url = "https://picsum.photos/128/128?random=${random}"
        val dateAjout = LocalDateTime.now().toString()

        viewModel.insertBattery("",url, dateAjout)
    }
}

