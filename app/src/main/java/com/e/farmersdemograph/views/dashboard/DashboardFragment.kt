package com.e.farmersdemograph.views.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.e.farmersdata.data.models.FarmersData

import com.e.farmersdemograph.R
import com.e.farmersdemograph.views.viewFarmers.ViewFarmerViewModel
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : DaggerFragment(), DashboardAdapter.ItemClickListener {
    private lateinit var viewModel: ViewFarmerViewModel

    @Inject
    internal lateinit var factory: ViewModelProvider.Factory
    private lateinit var mAdapter: DashboardAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[ViewFarmerViewModel::class.java]

        mAdapter = DashboardAdapter(this)
        recycler_view.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = mAdapter

        viewModel.getData().observe(viewLifecycleOwner, Observer { data ->
            farmers_total_number.text = data.size.toString()
            mAdapter.setItems(data)
        })



    }

    override fun onListItemClick(farmersData: FarmersData) {


    }
}
