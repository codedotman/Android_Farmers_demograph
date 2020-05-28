package com.e.farmersdemograph.di.components

import com.e.farmersdemograph.FarmerDataApplication
import com.e.farmersdemograph.di.builders.ActivityBuilder
import com.e.farmersdemograph.di.module.FarmerDataModule
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, FarmerDataModule::class, ActivityBuilder::class])

interface FarmerDataComponent:AndroidInjector<FarmerDataApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<FarmerDataApplication?>()

}