package com.rocklobstre.coolRecyclerview.data.remote

import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.data.remote.response.Response
import com.rocklobstre.coolRecyclerview.domain.model.Color
import com.rocklobstre.coolRecyclerview.domain.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Matin Salehi on 30/12/2017.
 */
interface Api {

    @GET("users")
    fun fetchUsers(): Observable<ApiListResponse<User>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): Observable<Response<User>>

    @GET("colors")
    fun fetchColors(): Observable<ApiListResponse<Color>>

}