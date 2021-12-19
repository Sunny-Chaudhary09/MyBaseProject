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
import android.widget.Toast

import android.app.Activity

import android.content.Intent
import android.util.Log


class MainActivity : AppCompatActivity() {

    var employeList: ArrayList<Data> = ArrayList()
    lateinit var Adapter: Adapter



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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                val result: Data? = data?.getSerializableExtra("result") as Data?
                val position = data?.getIntExtra("position", 0)
                if (position != null) {
                    if (result != null) {
                        employeList.set(position, result)
                    }
                }
                if (position != null) {
                    Adapter.notifyItemChanged(position)
                }
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "No result", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
