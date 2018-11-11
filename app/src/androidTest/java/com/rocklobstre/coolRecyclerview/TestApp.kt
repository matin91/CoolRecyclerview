package com.rocklobstre.coolRecyclerview

import com.rocklobstre.coolRecyclerview.di.DaggerTestAppComponent
import dagger.android.AndroidInjector

/**
 * @author wellingtoncosta on 06/02/18.
 */
class TestApp : App() {

    override fun applicationInjector(): AndroidInjector<out TestApp> {
        return DaggerTestAppComponent.builder().create(this)
    }

}