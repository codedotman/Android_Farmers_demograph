package com.e.farmersdemograph.views.addFarmer

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AddFarmerFragmentProvider {
    @ContributesAndroidInjector(modules = [AddFarmerModule::class])
    internal abstract fun contributeAddFarmerLocationProvider(): AddFarmerLocationFragment
}