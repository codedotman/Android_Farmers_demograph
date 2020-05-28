package com.e.farmersdata.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.e.farmersdata.data.models.FarmersData
import io.reactivex.Flowable

@Dao
interface FarmerDataDao {
    @Insert
    fun insertDetails(farmersData: FarmersData)

    @Query("SELECT * FROM farmerData")
    fun queryData(): Flowable<List<FarmersData>>
}