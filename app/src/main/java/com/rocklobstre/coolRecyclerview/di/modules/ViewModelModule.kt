package com.rocklobstre.coolRecyclerview.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.rocklobstre.coolRecyclerview.di.keys.ViewModelKey
import com.rocklobstre.coolRecyclerview.ui.colors.ListColorsViewModel
import com.rocklobstre.coolRecyclerview.ui.common.ViewModelFactory
import com.rocklobstre.coolRecyclerview.ui.users.DetailUserViewModel
import com.rocklobstre.coolRecyclerview.ui.users.ListUsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Matin Salehi on 31/12/2017.
 */
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListUsersViewModel::class)
    fun bindListUsersViewModel(listUsersViewModel: ListUsersViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListColorsViewModel::class)
    fun bindListColorsViewModel(listColorsViewModel: ListColorsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailUserViewModel::class)
    fun bindDetailUserViewModel(listColorsViewModel: DetailUserViewModel) : ViewModel


    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}