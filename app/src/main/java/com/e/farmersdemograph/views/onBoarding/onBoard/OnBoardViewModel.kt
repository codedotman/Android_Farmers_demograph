package com.e.farmersdemograph.views.onBoarding.onBoard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.farmersdata.data.models.OnBoardSlide

class OnBoardViewModel: ViewModel() {

    val setData = MutableLiveData<List<OnBoardSlide>>()
    val getData: LiveData<List<OnBoardSlide>> = setData

}