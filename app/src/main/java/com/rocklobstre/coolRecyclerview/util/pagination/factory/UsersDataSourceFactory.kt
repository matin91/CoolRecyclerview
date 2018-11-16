package com.vanethos.example.utils.pagination.factory

import android.arch.paging.DataSource
import com.rocklobstre.coolRecyclerview.domain.model.User
import com.rocklobstre.coolRecyclerview.util.pagination.datasource.UsersDataSource
import com.rocklobstre.coolRecyclerview.util.pagination.datasource._base.OnDataSourceLoading

/**
 * Factory class that handles the creation of DataSources
 */
class UsersDataSourceFactory(var loading: OnDataSourceLoading,
                             var user: String?) : DataSource.Factory<Int, User>() {
    lateinit var source : UsersDataSource

    override fun create(): DataSource<Int, User>? {
        // invalidate the previous data source, if available
        if (::source.isInitialized && source != null) source.invalidate()
        // if we have a user, then create a data source
        if (user != null) {
            source = UsersDataSource(user!!)
            source.onDataSourceLoading = loading
            return source
        }
        return null
    }



}