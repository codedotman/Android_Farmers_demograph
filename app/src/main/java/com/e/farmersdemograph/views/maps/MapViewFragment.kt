package com.e.farmersdemograph.views.maps

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.e.farmersdemograph.R
import com.e.farmersdemograph.views.viewFarmers.ViewFarmersDetailsFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.PolygonOptions
import kotlinx.android.synthetic.main.fragment_map_view.*
import kotlinx.android.synthetic.main.fragment_view_farmers_details.*

/**
 * A simple [Fragment] subclass.
 */
class MapViewFragment : Fragment(), OnMapReadyCallback {

    lateinit var mMap: GoogleMap
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
        return inflater.inflate(R.layout.fragment_map_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)
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


        }
    }

    override fun onMapReady(p0: GoogleMap) {

        mMap = p0

        val polygon1: Polygon = p0.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(lat1, long1),
                    LatLng(lat2, long2),
                    LatLng(lat3, long3),
                    LatLng(lat4, long4)

                )
        )

        polygon1.tag = "alpha"
        polygon1.fillColor = Color.RED
        p0.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-29.501, 119.700), 8f))



    }

    companion object {

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
