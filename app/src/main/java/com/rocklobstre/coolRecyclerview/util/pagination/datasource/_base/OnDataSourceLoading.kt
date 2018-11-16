package com.rocklobstre.coolRecyclerview.util.pagination.datasource._base

/**
 * Interface that will let us communicate between
 * @see BaseDataSource class
 * and
 * @see com.rocklobstre.coolRecyclerview.presentation.ui.base.BasePaginationViewModel
 */
interface OnDataSourceLoading {
    fun onFirstFetch()
    fun onFirstFetchEndWithData()
    fun onFirstFetchEndWithoutData()
    fun onDataLoading()
    fun onDataLoadingEnd()
    fun onInitialError()
    fun onError()
}