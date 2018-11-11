package com.rocklobstre.coolRecyclerview.di.modules

import com.rocklobstre.coolRecyclerview.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Matin Salehi on 31/12/2017.
 */
@Module
interface ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    fun contributeMainActivity(): MainActivity

}