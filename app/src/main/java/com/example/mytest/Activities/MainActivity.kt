package com.example.mytest.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.Adapters.Adapter
import com.example.mytest.Data
import com.example.mytest.DataClass
import com.example.mytest.R
import com.example.mytest.api.RestClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var employeList: ArrayList<Data> = ArrayList()
    lateinit var Adapter: Adapter
    var originalList: ArrayList<Data> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        hitapi_getEmployeData()


        btn_delete.setOnClickListener {


        }



    }


    private fun initRecyclerView() {
        Adapter = Adapter(employeList, this)
        rv_list.adapter = Adapter
    }

    private fun hitapi_getEmployeData() {

        RestClient.get().get_employee().enqueue(object : Callback<DataClass> {
            override fun onFailure(call: Call<DataClass>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<DataClass>,
                response: Response<DataClass>
            ) {

                if (response.body() != null) {
                    employeList.addAll(response.body()!!.data).toString()
                    Adapter.notifyDataSetChanged()
                }

                try {
                    if (response.isSuccessful && response.body() != null) {
                        employeList.addAll(response.body()!!.data)

                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })


    }









}
