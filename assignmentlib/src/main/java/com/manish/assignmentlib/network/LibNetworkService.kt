package com.manish.assignmentlib.network

import com.manish.assignmentlib.model.Facts
import io.reactivex.Single
import retrofit2.http.GET

interface LibNetworkService {
    @GET("facts.json")
    fun getFacts() : Single<Facts>
}