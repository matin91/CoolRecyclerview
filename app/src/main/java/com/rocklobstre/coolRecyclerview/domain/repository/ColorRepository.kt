package com.rocklobstre.coolRecyclerview.domain.repository

import com.rocklobstre.coolRecyclerview.data.remote.Api
import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.domain.model.Color
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Matin Salehi on 30/12/2017.
 */
open class ColorRepository @Inject constructor(private val api: Api) {

    fun getColors(): Observable<ApiListResponse<Color>> {
        return api.fetchColors()
    }

}