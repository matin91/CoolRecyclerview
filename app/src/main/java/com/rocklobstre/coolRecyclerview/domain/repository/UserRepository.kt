package com.rocklobstre.coolRecyclerview.domain.repository

import com.rocklobstre.coolRecyclerview.data.remote.Api
import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.data.remote.response.Response
import com.rocklobstre.coolRecyclerview.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Matin Salehi on 30/12/2017.
 */
class UserRepository @Inject constructor(private val api: Api) {

    fun getUsers(): Observable<ApiListResponse<User>> {
        return api.fetchUsers()
    }

    fun getUserById(id : Int): Observable<Response<User>> {
        return api.getUser(id)
    }

}