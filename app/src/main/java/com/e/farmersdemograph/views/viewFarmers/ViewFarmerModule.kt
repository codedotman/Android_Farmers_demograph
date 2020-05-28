package com.e.farmersdemograph.views.viewFarmers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.farmersdata.data.Repository
import com.e.farmersdata.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ViewFarmerModule {
    @Provides
    internal fun provideViewModel(repository: Repository): ViewFarmerViewModel{
        return ViewFarmerViewModel(repository)
    }
    @Provides
    internal fun provideViewModelFactory(viewModel: ViewFarmerViewModel): ViewModelProvider.Factory{
        return ViewModelProviderFactory(viewModel)
    }
}