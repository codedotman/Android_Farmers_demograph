package com.e.farmersdata.data

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e.farmersdata.data.local.FarmerDataDao
import com.e.farmersdata.data.models.FarmersData
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class Repository @Inject constructor(
    private val dao: FarmerDataDao){
    @SuppressLint("CheckResult")
    fun saveFarmerDetails(farmersData: FarmersData) {

        Completable.fromRunnable { dao.insertDetails(farmersData)}
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    @SuppressLint("CheckResult")
    fun fetchFarmersDetailsFromDb(): LiveData<List<FarmersData>> {
        val dBResponse = MutableLiveData<List<FarmersData>>()

        val responseObservable = dao.queryData()
        responseObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .switchIfEmpty { }
            .firstOrError()
            .subscribe(
                { response ->
                    dBResponse.postValue(response) },
                { _ -> }
            )
        return dBResponse
    }

}

