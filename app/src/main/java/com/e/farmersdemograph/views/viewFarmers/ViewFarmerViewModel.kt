package com.e.farmersdemograph.views.viewFarmers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.farmersdata.data.Repository
import com.e.farmersdata.data.models.FarmersData
import dagger.Module
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@Module
class ViewFarmerViewModel  @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var liveData = MutableLiveData<List<FarmersData>>()

    fun getData(): LiveData<List<FarmersData>> {
        liveData = repository.fetchFarmersDetailsFromDb() as MutableLiveData<List<FarmersData>>
        return liveData
    }


}