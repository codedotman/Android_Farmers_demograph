package com.e.farmersdemograph.di.module

import android.content.Context
import androidx.room.Room
import com.e.farmersdata.data.Repository
import com.e.farmersdata.data.local.AppDatabase
import com.e.farmersdata.data.local.FarmerDataDao
import com.e.farmersdemograph.FarmerDataApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FarmerDataModule {
    @Singleton
    @Provides
    internal fun provideContext(application: FarmerDataApplication): Context {
        return application
    }

    @Provides
    internal fun provideRepository(dao: FarmerDataDao): Repository {
        return Repository(dao)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, "farmers_db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideFarmerDataDao(appDatabase: AppDatabase):
            FarmerDataDao = appDatabase.farmerDataDao()
}