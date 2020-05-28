package com.e.farmersdemograph.views.addFarmer

import android.util.Log
import androidx.lifecycle.ViewModel
import com.e.farmersdata.data.Repository
import com.e.farmersdata.data.models.FarmersData
import dagger.Module
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@Module
class AddFarmerViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun saveDetails(farmersData: FarmersData) {

        repository.saveFarmerDetails(farmersData);

    }
}