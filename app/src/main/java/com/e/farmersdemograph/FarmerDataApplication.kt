package com.e.farmersdemograph

import com.e.farmersdemograph.di.components.DaggerFarmerDataComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FarmerDataApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<FarmerDataApplication?>? {
        return DaggerFarmerDataComponent.builder().create(this)
    }
}