package com.rocklobstre.coolRecyclerview.domain.repository

import com.rocklobstre.coolRecyclerview.data.remote.Api
import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.data.remote.response.Response
import com.rocklobstre.coolRecyclerview.domain.MissingUseCaseParameterException
import com.rocklobstre.coolRecyclerview.domain.model.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Matin Salehi on 30/12/2017.
 */
class UserRepository @Inject constructor(private val api: Api) {

    fun getUsers(page : Int, perPage : Int): Observable<ApiListResponse<User>> {
        return api.fetchUsers(page, perPage)
    }

    fun getUserById(id : Int): Observable<Response<User>> {
        return api.getUser(id)
    }

}