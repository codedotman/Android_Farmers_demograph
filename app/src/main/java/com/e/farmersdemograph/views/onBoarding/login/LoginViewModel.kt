package com.e.farmersdemograph.views.onBoarding.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.farmersdata.data.models.LoginDetails

class LoginViewModel: ViewModel() {

    val setData = MutableLiveData<LoginDetails>()
    val getData: LiveData<LoginDetails> = setData
}