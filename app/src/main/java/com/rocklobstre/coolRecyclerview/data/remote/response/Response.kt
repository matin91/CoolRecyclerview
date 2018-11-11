package com.rocklobstre.coolRecyclerview.data.remote.response

/**
 * @author Matin Salehi on 30/12/2017.
 */
data class Response<out T> (
        val status: Int,
        val data: T?,
        val error: Throwable?
)