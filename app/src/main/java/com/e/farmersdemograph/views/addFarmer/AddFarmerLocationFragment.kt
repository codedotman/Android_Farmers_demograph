package com.e.farmersdemograph.views.addFarmer

import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.e.farmersdata.data.models.FarmersData

import com.e.farmersdemograph.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_add_farmer_location.*
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AddFarmerLocationFragment : DaggerFragment(){

    @Inject
    internal lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: AddFarmerViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latlng1: LatLng? = null
    private var latlng2: LatLng? = null
    private var latlng3: LatLng? = null
    private var latlng4: LatLng? = null
    private lateinit var farmersName: String
    private lateinit var farmersAge: String
    private lateinit var farmersImg: String
    private lateinit var farmersPhone: String
    private lateinit var farmersLocation: String
    private lateinit var farmersAccount: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        return inflater.inflate(R.layout.fragment_add_farmer_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, factory)[AddFarmerViewModel::class.java]

        arguments?.let{
            farmersName = it.getString(FARMERS_NAME).toString()
            farmersAge = it.getString(FARMERS_AGE).toString()
            farmersImg = it.getString(FARMERS_IMG).toString()
            farmersPhone = it.getString(FARMERS_PHONE).toString()
            farmersLocation = it.getString(FARM_LOCATION).toString()
            farmersAccount = it.getString(FARMERS_ACCOUNT).toString()


        }


        buttonPoint1.setOnClickListener {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location ->
                    latlng1 = LatLng(location.latitude, location.longitude)
                    imagePoint1.visibility = View.VISIBLE
                    Log.d("location1", latlng1.toString())

                }
        }
        buttonPoint2.setOnClickListener {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location ->
                    latlng2 = LatLng(location.latitude, location.longitude)
                    imagePoint2.visibility = View.VISIBLE

                    Log.d("location2", latlng2.toString())
                }
        }
        buttonPoint3.setOnClickListener {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location ->
                    latlng3 = LatLng(location.latitude, location.longitude)
                    imagePoint3.visibility = View.VISIBLE
                    Log.d("location3", latlng3.toString())
                }
        }
        buttonPoint4.setOnClickListener {
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location ->
                    latlng4 = LatLng(location.latitude, location.longitude)
                    imagePoint4.visibility = View.VISIBLE

                    Log.d("location4", latlng4.toString())
                }
        }
        completeBtn.setOnClickListener {
            if(latlng1==null || latlng2==null || latlng3==null || latlng4==null){
                Snackbar.make(login_root, "Take all points location to proceed", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(resources.getColor(R.color.colorPrimary))
                    .show()
            }else{
                val farmersData = FarmersData(name = farmersName, age = farmersAge, address = farmersLocation, phone = farmersPhone,image = farmersImg,
                    account = farmersAccount, lat1 = latlng1!!.latitude,lat2 = latlng2!!.latitude,lat3 = latlng3!!.latitude, lat4 = latlng4!!.latitude,
                    long1 = latlng1!!.longitude,long2 = latlng2!!.longitude, long3 = latlng3!!.longitude, long4 = latlng4!!.longitude)

                viewModel.saveDetails(farmersData)

                val navController = Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
                navController.navigate(R.id.action_addFarmerLocationFragment_to_dashboardFragment)
            }
        }

    }

    companion object {
        const val FARMERS_NAME = "FARMERS_NAME"
        const val FARMERS_AGE = "FARMERS_AGE"
        const val FARMERS_IMG = "FARMERS_IMG"
        const val FARMERS_PHONE = "FARMERS_PHONE"
        const val FARM_LOCATION = "FARM_LOCATION"
        const val FARMERS_ACCOUNT = "FARM_LOCATION"


    }


}
