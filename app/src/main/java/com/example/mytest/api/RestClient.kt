package com.example.mytest.api

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient {

    companion object {
        private lateinit var retrofit: Retrofit
        private lateinit var REST_CLIENT: Api

//        var API_URL ="https://howtodoandroid.com/"
        var API_URL ="http://dummy.restapiexample.com/api/v1/"

        @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
        fun get(): Api {
            val gson = GsonBuilder().setLenient().create()
            retrofit = Retrofit.Builder().baseUrl(API_URL).client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson)).build()
            REST_CLIENT = retrofit.create(Api::class.java)
            return REST_CLIENT
        }

        @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
        fun getOkHttpClient(): OkHttpClient {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val builder = OkHttpClient.Builder()
            builder.connectTimeout(5, TimeUnit.MINUTES)
            builder.readTimeout(5, TimeUnit.MINUTES)
            builder.writeTimeout(5, TimeUnit.MINUTES)
            builder.addNetworkInterceptor(httpLoggingInterceptor)
          builder.addInterceptor { chain ->
            val request = chain.request()
            val header = request.newBuilder()?.header("Authorization",
                  "Bearer ")
              val build = header!!.build()
             chain!!.proceed(build)
         }
            return builder.build()
        }


    }

}