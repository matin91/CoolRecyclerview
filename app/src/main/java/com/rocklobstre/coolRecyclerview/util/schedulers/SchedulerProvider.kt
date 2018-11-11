package com.rocklobstre.coolRecyclerview.util.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Matin Salehi on 31/12/2017.
 */
class SchedulerProvider : BaseScheduler {

    override fun io(): Scheduler {
        return Schedulers.newThread()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}