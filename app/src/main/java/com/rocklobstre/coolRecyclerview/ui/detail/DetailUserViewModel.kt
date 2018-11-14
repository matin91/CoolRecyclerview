package com.rocklobstre.coolRecyclerview.ui.users

import android.annotation.SuppressLint
import com.rocklobstre.coolRecyclerview.data.remote.response.Response
import com.rocklobstre.coolRecyclerview.data.remote.response.Status
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.rocklobstre.coolRecyclerview.domain.repository.UserRepository
import com.rocklobstre.coolRecyclerview.ui.base.BaseViewModel
import com.rocklobstre.coolRecyclerview.util.schedulers.BaseScheduler
import javax.inject.Inject

/**
 * @author Matin Salehi on 31/12/2017.
 */
class DetailUserViewModel
@Inject constructor(
        private val scheduler: BaseScheduler,
        private val userRepository: UserRepository
) : BaseViewModel<Int, User>() {

    @SuppressLint("CheckResult")
    override fun loadData(params: Int?) {
        userRepository.getUserById(params!!)
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe { loadingStatus.setValue(true) }
                .doAfterTerminate { loadingStatus.setValue(false) }
                .subscribe({
                    result -> response.setValue(Response(Status.SUCCESS, result.data, null))
                }, {
                    throwable -> response.setValue(Response(Status.ERROR, null, throwable))
                })

    }

}