package com.rocklobstre.coolRecyclerview.di

import com.rocklobstre.coolRecyclerview.data.remote.Api
import com.rocklobstre.coolRecyclerview.data.remote.response.ApiListResponse
import com.rocklobstre.coolRecyclerview.di.modules.ViewModelModule
import com.rocklobstre.coolRecyclerview.domain.repository.ColorRepository
import com.rocklobstre.coolRecyclerview.domain.repository.UserRepository
import com.rocklobstre.coolRecyclerview.mock.Mocks.createColors
import com.rocklobstre.coolRecyclerview.mock.Mocks.createUsers
import com.rocklobstre.coolRecyclerview.util.schedulers.BaseScheduler
import com.rocklobstre.coolRecyclerview.util.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.Observable.just
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import javax.inject.Singleton

/**
 * @author wellingtoncosta on 06/02/18.
 */
@Module(includes = [(ViewModelModule::class)])
internal class TestAppModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
        val api = mock<Api>(Api::class.java)
        `when`(api.fetchUsers()).thenReturn(just(ApiListResponse(
                0,
                0,
                0,
                0,
                createUsers()
        )))
        `when`(api.fetchColors()).thenReturn(just(ApiListResponse(
                0,
                0,
                0,
                0,
                createColors()
        )))
        return api
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: Api): UserRepository {
        return UserRepository(api)
    }

    @Provides
    @Singleton
    fun provideRepoRepository(api: Api): ColorRepository {
        return ColorRepository(api)
    }

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }

}