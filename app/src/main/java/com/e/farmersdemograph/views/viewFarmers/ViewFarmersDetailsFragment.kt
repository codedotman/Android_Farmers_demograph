package com.e.farmersdemograph.views.viewFarmers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation

import com.e.farmersdemograph.R
import com.e.farmersdemograph.views.maps.MapViewFragment
import kotlinx.android.synthetic.main.fragment_view_farmers_details.*

/**
 * A simple [Fragment] subclass.
 */
class ViewFarmersDetailsFragment : Fragment() {

    var lat1: Double = 0.0
    var lat2: Double = 0.0
    var lat3: Double = 0.0
    var lat4: Double = 0.0
    var long1: Double = 0.0
    var long2: Double = 0.0
    var long3: Double = 0.0
    var long4: Double = 0.0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_farmers_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            lat1 = it.getString(FARM_LAT1)?.toDouble() ?: 0.00
            lat2 = it.getString(FARM_LAT2)?.toDouble() ?: 0.00
            lat3 = it.getString(FARM_LAT3)?.toDouble() ?: 0.00
            lat4 = it.getString(FARM_LAT4)?.toDouble() ?: 0.00
            long1 = it.getString(FARM_LON1)?.toDouble() ?: 0.00
            long2= it.getString(FARM_LON2)?.toDouble() ?: 0.00
            long3 = it.getString(FARM_LON3)?.toDouble() ?: 0.00
            long4 = it.getString(FARM_LON4)?.toDouble() ?: 0.00

            f_name.text = it.getString(FARMERS_NAME).toString()
            f_age.text = it.getString(FARMERS_AGE).toString()
            f_location.text = it.getString(FARM_LOCATION).toString()
            img_avatar.setImageBitmap(it.getString(FARMERS_IMG)?.convertToBitMap())
            phone_details.text = it.getString(FARMERS_PHONE).toString()
            bank_details.text = it.getString(FARMERS_ACCOUNT).toString()


        }



        val bundle = bundleOf()
        bundle.apply {
            putString(MapViewFragment.FARM_LAT1, lat1.toString())
            putString(MapViewFragment.FARM_LAT2, lat2.toString())
            putString(MapViewFragment.FARM_LAT3, lat3.toString())
            putString(MapViewFragment.FARM_LAT4, lat4.toString())
            putString(MapViewFragment.FARM_LON1, long1.toString())
            putString(MapViewFragment.FARM_LON2, long2.toString())
            putString(MapViewFragment.FARM_LON3, long3.toString())
            putString(MapViewFragment.FARM_LON4, long4.toString())



        }

        button.setOnClickListener {  val navController =
            Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
            navController.navigate(
                R.id.action_viewFarmersDetailsFragment_to_viewMapsFragment2, bundle) }
    }

    fun String.convertToBitMap(): Bitmap? {
        return try {
            val encodeByte = Base64.decode(this, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            null
        }

    }

    companion object {
        const val FARMERS_NAME = "FARMERS_NAME"
        const val FARMERS_AGE = "FARMERS_AGE"
        const val FARMERS_IMG = "FARMERS_IMG"
        const val FARMERS_PHONE = "FARMERS_PHONE"
        const val FARM_LOCATION = "FARM_LOCATION"
        const val FARMERS_ACCOUNT = "FARM_LOCATION"
        const val FARM_LAT1 = "LAT1"
        const val FARM_LON1 = "L0N1"
        const val FARM_LAT2 = "LAT2"
        const val FARM_LON2 = "LON2"
        const val FARM_LAT3 = "LAT3"
        const val FARM_LON3 = "LON3"
        const val FARM_LAT4 = "LAT4"
        const val FARM_LON4 = "LON4"


    }


}
