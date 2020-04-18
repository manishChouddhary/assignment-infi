package com.manish.assignmentlib

import retrofit2.Retrofit

interface LibCallback {
    fun getRetrofitClient() : Retrofit
}