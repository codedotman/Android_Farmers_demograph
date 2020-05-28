package com.e.farmersdata.data

import com.e.farmersdata.data.local.FarmerDataDao
import javax.inject.Inject


class Repository @Inject constructor(
    private val dao: FarmerDataDao
)

