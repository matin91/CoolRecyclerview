package com.rocklobstre.coolRecyclerview.di.modules

import com.rocklobstre.coolRecyclerview.ui.colors.ListColorsFragment
import com.rocklobstre.coolRecyclerview.ui.users.ListUsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Matin Salehi on 31/12/2017.
 */
@Module
interface FragmentBuildersModule {

    @ContributesAndroidInjector
    fun contributeListUsersFragment(): ListUsersFragment

    @ContributesAndroidInjector
    fun contributeListColorsFragment(): ListColorsFragment

}