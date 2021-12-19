package com.example.mytest.api

import com.example.mytest.DataClass
import com.example.mytest.models.TestModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
        
        @GET("employees")
        fun get_employee(): Call<DataClass>

        @GET("movielist.json")
        fun getAllMovies(): Call<TestModel>

}


