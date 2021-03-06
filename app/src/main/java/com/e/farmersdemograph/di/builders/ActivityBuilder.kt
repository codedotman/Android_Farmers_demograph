package com.e.farmersdemograph.di.builders

import com.e.farmersdemograph.MainActivity
import com.e.farmersdemograph.views.addFarmer.AddFarmerFragmentProvider
import com.e.farmersdemograph.views.viewFarmers.ViewFarmerFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ViewFarmerFragmentProvider::class, AddFarmerFragmentProvider::class])
    internal abstract fun contributeMainActivityModule(): MainActivity

}