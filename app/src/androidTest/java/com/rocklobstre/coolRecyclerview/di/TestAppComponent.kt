package com.rocklobstre.coolRecyclerview.di

import com.rocklobstre.coolRecyclerview.TestApp
import com.rocklobstre.coolRecyclerview.di.modules.ActivityBuildersModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author wellingtoncosta on 06/02/18.
 */
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (ActivityBuildersModule::class),
    (TestAppModule::class)
])
interface TestAppComponent : AndroidInjector<TestApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestApp>()

}