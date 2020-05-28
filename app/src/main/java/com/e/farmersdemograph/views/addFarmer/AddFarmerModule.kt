package com.e.farmersdemograph.views.addFarmer

import androidx.lifecycle.ViewModelProvider
import com.e.farmersdata.data.Repository
import com.e.farmersdata.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class AddFarmerModule {
    @Provides
    internal fun provideViewModel(repository: Repository): AddFarmerViewModel {
        return AddFarmerViewModel(repository)
    }

    @Provides
    internal fun provideViewModelFactory(viewModel: AddFarmerViewModel): ViewModelProvider.Factory{
        return ViewModelProviderFactory(viewModel)
    }
}