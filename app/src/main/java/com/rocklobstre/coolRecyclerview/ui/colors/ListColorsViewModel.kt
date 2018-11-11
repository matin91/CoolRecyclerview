package com.rocklobstre.coolRecyclerview.ui.colors

import com.rocklobstre.coolRecyclerview.data.remote.response.Response
import com.rocklobstre.coolRecyclerview.data.remote.response.Status
import com.rocklobstre.coolRecyclerview.domain.model.Color
import com.rocklobstre.coolRecyclerview.domain.repository.ColorRepository
import com.rocklobstre.coolRecyclerview.ui.base.BaseViewModel
import com.rocklobstre.coolRecyclerview.util.schedulers.BaseScheduler
import javax.inject.Inject

/**
 * @author Matin Salehi on 31/12/2017.
 */
class ListColorsViewModel
@Inject constructor(
        private val scheduler: BaseScheduler,
        private val colorRepository: ColorRepository
) : BaseViewModel<List<Color>>() {

    override fun loadData() {
        colorRepository.getColors()
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