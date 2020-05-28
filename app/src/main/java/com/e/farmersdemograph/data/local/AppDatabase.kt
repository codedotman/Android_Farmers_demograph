package com.e.farmersdata.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.e.farmersdata.data.models.FarmersData

@Database(entities = [FarmersData::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun farmerDataDao(): FarmerDataDao

}