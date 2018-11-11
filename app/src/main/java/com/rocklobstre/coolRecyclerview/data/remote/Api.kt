package com.rocklobstre.coolRecyclerview.data.remote

import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.domain.model.Color
import com.rocklobstre.coolRecyclerview.domain.model.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author Matin Salehi on 30/12/2017.
 */
interface Api {

    @GET("users")
    fun fetchUsers(): Observable<ApiListResponse<User>>

    @GET("colors")
    fun fetchColors(): Observable<ApiListResponse<Color>>

}