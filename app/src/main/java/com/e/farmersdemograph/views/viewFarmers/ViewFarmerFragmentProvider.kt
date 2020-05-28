package com.e.farmersdemograph.views.viewFarmers

import com.e.farmersdemograph.views.dashboard.DashboardFragment
import com.e.farmersdemograph.views.dashboard.viewAllFarmers.ViewAllFarmersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewFarmerFragmentProvider {

    @ContributesAndroidInjector(modules = arrayOf(ViewFarmerModule::class))
    internal abstract fun contributeDashboardProvider(): DashboardFragment

    @ContributesAndroidInjector(modules = arrayOf(ViewFarmerModule::class))
    internal abstract fun contributeViewAllFarmersProvider(): ViewAllFarmersFragment


}