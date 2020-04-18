package com.manish.assignmentlib

import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(private val request: MockRequest) : Interceptor {
    enum class MockRequest{
        FACTS_UPDATE_SUCCESS,
        FACTS_UPDATE_ERROR
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val requestBuilder = chain.request().newBuilder()
        return when(this.request){
            MockRequest.FACTS_UPDATE_SUCCESS ->{
                val code = 200
                val json:String = MockProvider.getFactResponse()
                Response.Builder()
                    .code(code)
                    .body(json.toResponseBody("application/json".toMediaType()))
                    .message(json)
                    .request(requestBuilder.build())
                    .protocol(Protocol.HTTP_2)
                    .build()
            }
            MockRequest.FACTS_UPDATE_ERROR ->{
                throw Exception()
            }

        }
    }
}