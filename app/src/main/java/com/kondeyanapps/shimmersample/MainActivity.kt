package com.kondeyanapps.shimmersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kondeyanapps.shimmersample.databinding.ActivityMainBinding
import com.kondeyanapps.shimmersample.model.Accounts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *
 * Aim: To demonstrate shimmer animation on recyclerview and individual page
 * What we will make
 *
 * 1. Recycler view with cards like accounts
 * 2. Sample page
 */

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding

    private val model: ShimmerViewModel by viewModels()
    private lateinit var recyclerViewAdapter: ShimmerRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Create the observer which updates the UI.
        val nameObserver = Observer<List<Accounts>> { accountList ->
            linearLayoutManager = LinearLayoutManager(this)
            recyclerViewAdapter = ShimmerRecyclerViewAdapter(accountList)
            binding.accountsRecyclerView.apply {
                layoutManager = linearLayoutManager
                adapter = recyclerViewAdapter
            }
            recyclerViewAdapter.apply {
                binding.shimmerViewContainer.stopShimmer()
                binding.shimmerViewContainer.hideShimmer()
                binding.skeleton.visibility = View.GONE
                binding.accountsRecyclerView.visibility = View.VISIBLE

            }
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.accountsLiveData.observe(this, nameObserver)
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerViewContainer.startShimmer()
        GlobalScope.launch {
            Thread.sleep(5000)
            model.updateData()
        }

    }
}
