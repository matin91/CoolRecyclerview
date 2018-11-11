package com.rocklobstre.coolRecyclerview.di.components

import com.rocklobstre.coolRecyclerview.App
import com.rocklobstre.coolRecyclerview.di.modules.ActivityBuildersModule
import com.rocklobstre.coolRecyclerview.di.modules.AppModule
import com.rocklobstre.coolRecyclerview.di.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author Matin Salehi on 31/12/2017.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}