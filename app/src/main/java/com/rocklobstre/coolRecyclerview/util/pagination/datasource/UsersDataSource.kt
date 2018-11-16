package com.rocklobstre.coolRecyclerview.util.pagination.datasource

import android.annotation.SuppressLint
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.rocklobstre.coolRecyclerview.domain.repository.UserRepository
import com.rocklobstre.coolRecyclerview.util.pagination.datasource._base.BaseDataSource
import com.rocklobstre.coolRecyclerview.util.schedulers.BaseScheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Class that handles how to retrieve data for the recyclerview
 * @see BaseDataSource
 */
class UsersDataSource
    @Inject constructor(
    private val userRepository: UserRepository
    ) : BaseDataSource<User>() {

    @SuppressLint("CheckResult")
    override fun loadInitialData(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        // in the initial load, we will start at page 0, and retrieve the number of pages in the params.requestLoadSize
        userRepository.getUsers(0, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(this::addDisposable)
                .subscribe(
                        { items -> submitInitialData(items.data, params, callback) },
                        { error -> submitInitialError(error) }
                )
    }

    @SuppressLint("CheckResult")
    override fun loadAditionalData(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        userRepository.getUsers(params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(this::addDisposable)
                .subscribe(
                        { items -> submitData(items.data, params, callback) },
                        { error -> submitError(error) }
                )
    }
}