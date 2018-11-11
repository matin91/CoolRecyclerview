package com.rocklobstre.coolRecyclerview

import com.rocklobstre.coolRecyclerview.di.components.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * @author Matin Salehi on 31/12/2017.
 */
open class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().create(this)
    }

}