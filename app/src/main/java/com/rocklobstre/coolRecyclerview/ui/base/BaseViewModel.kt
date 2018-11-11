package com.rocklobstre.coolRecyclerview.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.rocklobstre.coolRecyclerview.data.remote.response.Response

/**
 * @author Matin Salehi on 31/12/2017.
 */
abstract class BaseViewModel<T> : ViewModel() {

    val response: MutableLiveData<Response<T>> = MutableLiveData()

    val loadingStatus: MutableLiveData<Boolean> = MutableLiveData()

    abstract fun loadData()

}