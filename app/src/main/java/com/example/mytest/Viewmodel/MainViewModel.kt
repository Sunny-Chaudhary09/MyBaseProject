package com.example.mytest.Viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mytest.api.RestClient
import com.example.mytest.models.TestModel

import com.example.mytest.models.TestModelItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(application:Application)  : AndroidViewModel(application) {

    val movieList = MutableLiveData<List<TestModelItem>>()
    val errorMessage = MutableLiveData<String>()

    fun mainResponse(){
        RestClient.get().getAllMovies().enqueue(object : Callback<TestModel>{

            override fun onResponse(call: Call<TestModel>, response: Response<TestModel>) {
                movieList.value=response.body()
            }

            override fun onFailure(call: Call<TestModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }

    fun onGetResponse()=movieList

}