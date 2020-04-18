package com.assignment.manish.assignment

import com.assignment.manish.assignment.network.NetworkClient
import com.manish.assignmentlib.LibCallback
import retrofit2.Retrofit

class LibCallbackImplementation: LibCallback {
    override fun getRetrofitClient() : Retrofit {
        return NetworkClient().getRetrofitClient(AppApplication.assetLoader.getConfig().host)
    }
}