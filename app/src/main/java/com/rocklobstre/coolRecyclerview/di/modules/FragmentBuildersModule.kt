package com.rocklobstre.coolRecyclerview.di.modules

import com.rocklobstre.coolRecyclerview.ui.colors.ListColorsFragment
import dagger.Module
import com.rocklobstre.coolRecyclerview.ui.users.DetailUserFragment
import dagger.android.ContributesAndroidInjector

/**
 * @author Matin Salehi on 31/12/2017.
 */
@Module
interface FragmentBuildersModule {

    @ContributesAndroidInjector
    fun contributeListUsersFragment(): DetailUserFragment

    @ContributesAndroidInjector
    fun contributeListColorsFragment(): ListColorsFragment

}