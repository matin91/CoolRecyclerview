package com.rocklobstre.coolRecyclerview.di.modules

import com.andremion.theatre.navigation.Navigator
import com.rocklobstre.coolRecyclerview.data.remote.Api
import com.rocklobstre.coolRecyclerview.domain.repository.ColorRepository
import com.rocklobstre.coolRecyclerview.domain.repository.UserRepository
import com.rocklobstre.coolRecyclerview.util.schedulers.BaseScheduler
import com.rocklobstre.coolRecyclerview.util.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Matin Salehi on 31/12/2017.
 */
@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retorfit: Retrofit) : Api {
        return retorfit.create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: Api): UserRepository {
        return UserRepository(api)
    }

    @Provides
    @Singleton
    fun provideColorRepository(api: Api): ColorRepository {
        return ColorRepository(api)
    }

    @Provides
    @Singleton
    fun provideScheduler(): BaseScheduler {
        return SchedulerProvider()
    }

    @Provides
    @Singleton
    internal fun provideNavigator() = Navigator()

}