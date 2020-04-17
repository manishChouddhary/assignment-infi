package com.manish.assignmentlib.network

import retrofit2.http.GET
import java.util.*

interface LibNetworkService {
    @GET("/facts.json")
    fun getFacts()
}