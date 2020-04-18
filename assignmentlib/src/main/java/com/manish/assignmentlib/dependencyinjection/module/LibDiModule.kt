package com.manish.assignmentlib.dependencyinjection.module

import com.manish.assignmentlib.LibCallback
import com.manish.assignmentlib.LibModule
import com.manish.assignmentlib.network.LibNetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class LibDiModule {
    @Provides
    fun provideLibCallback(): LibCallback = LibModule.getInstance().libCallback

    @Provides
    fun provideRetrofitClient(callback: LibCallback) :Retrofit {
        return callback.getRetrofitClient()
    }

    @Provides
    fun provideLibNetworkService(retrofit: Retrofit) : LibNetworkService {
        return retrofit.create(LibNetworkService::class.java)
    }

}