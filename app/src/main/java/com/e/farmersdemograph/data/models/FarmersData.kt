package com.e.farmersdata.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity(tableName = "farmerData")
data class FarmersData(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var name: String? = "",
    var age: String? = "",
    var address: String? = "",
    var phone: String? = "",
    var account: String? = "",
    var image: String? = "",
    var lat1: Double? = 0.0,
    var lat2: Double?= 0.0,
    var lat3: Double?= 0.0,
    var lat4: Double?= 0.0,
    var long1: Double?= 0.0,
    var long2: Double?= 0.0,
    var long3: Double?= 0.0,
    var long4: Double?= 0.0



)

data class LoginDetails(
    var email: String? = "",
    var password: String? = ""
)
