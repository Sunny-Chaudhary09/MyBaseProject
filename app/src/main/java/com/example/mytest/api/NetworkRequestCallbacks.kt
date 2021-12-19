package com.example.mytest.api

import retrofit2.Response

interface NetworkRequestCallbacks {

    fun onSuccess(response: Response<*>)

    fun onError(t: Throwable)


}