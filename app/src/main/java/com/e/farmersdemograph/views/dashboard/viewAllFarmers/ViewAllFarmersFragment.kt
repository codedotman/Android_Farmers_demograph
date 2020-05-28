package com.e.farmersdemograph.views.dashboard.viewAllFarmers

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
import com.e.farmersdemograph.views.dashboard.DashboardAdapter
import com.e.farmersdemograph.views.viewFarmers.ViewFarmerViewModel
import com.e.farmersdemograph.views.viewFarmers.ViewFarmersDetailsFragment
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_view_all_farmers.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ViewAllFarmersFragment : DaggerFragment(), DashboardAdapter.ItemClickListener {

    private lateinit var viewModel: ViewFarmerViewModel
    @Inject
    internal lateinit var factory: ViewModelProvider.Factory
    private lateinit var mAdapter: DashboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_all_farmers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[ViewFarmerViewModel::class.java]

        mAdapter = DashboardAdapter(this)
        view_farmers_recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view_farmers_recycler_view.adapter = mAdapter

        viewModel.getData().observe(viewLifecycleOwner, Observer { data ->
            mAdapter.setItems(data)
        })

    }



    override fun onListItemClick(farmersData: FarmersData) {

        val bundle = bundleOf()
        bundle.apply {
            putString(ViewFarmersDetailsFragment.FARMERS_NAME, farmersData.name)
            putString(ViewFarmersDetailsFragment.FARMERS_AGE, farmersData.age)
            putString(ViewFarmersDetailsFragment.FARMERS_IMG, farmersData.image)
            putString(ViewFarmersDetailsFragment.FARMERS_PHONE, farmersData.phone)
            putString(ViewFarmersDetailsFragment.FARM_LOCATION, farmersData.address)
            putString(ViewFarmersDetailsFragment.FARMERS_ACCOUNT, farmersData.account)
            putString(ViewFarmersDetailsFragment.FARM_LAT1, farmersData.lat1.toString())
            putString(ViewFarmersDetailsFragment.FARM_LAT2, farmersData.lat2.toString())
            putString(ViewFarmersDetailsFragment.FARM_LAT3, farmersData.lat3.toString())
            putString(ViewFarmersDetailsFragment.FARM_LAT4, farmersData.lat4.toString())
            putString(ViewFarmersDetailsFragment.FARM_LON1, farmersData.long1.toString())
            putString(ViewFarmersDetailsFragment.FARM_LON2, farmersData.long2.toString())
            putString(ViewFarmersDetailsFragment.FARM_LON3, farmersData.long3.toString())
            putString(ViewFarmersDetailsFragment.FARM_LON4, farmersData.long4.toString())


            val navController =
                Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
            navController.navigate(
                R.id.action_viewAllFarmersFragment_to_viewFarmersDetailsFragment,
                bundle
            )

        }


        }

    }



