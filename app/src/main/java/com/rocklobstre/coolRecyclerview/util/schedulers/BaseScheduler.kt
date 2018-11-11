package com.rocklobstre.coolRecyclerview.util.schedulers

import android.support.annotation.NonNull
import io.reactivex.Scheduler



/**
 * @author Matin Salehi on 31/12/2017.
 */
interface BaseScheduler {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler

}