package com.example.mytest.Activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable

import android.text.TextWatcher
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.widget.EditText
import com.example.mytest.Model
import com.example.mytest.MyAdapter
import com.example.mytest.R
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {



    companion object {

        var recyclerViewList: ArrayList<Model> = ArrayList()
        var myAdapter: MyAdapter? = null
        var originalList: ArrayList<Model> = ArrayList()
        var textView = (R.id.textView1)

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        if (edtSearch != null) {
            edtSearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    search(charSequence.toString().trim { it <= ' ' })
                }

                override fun afterTextChanged(editable: Editable) {}
            })
        }

        fillDataToList()


    }

    private fun fillDataToList() {

        for (i in 0..99) {
            val model = Model(i.toString() + "text", false)
            recyclerViewList.add(model)
            originalList.add(model)
        }

        myAdapter = MyAdapter(this, recyclerViewList)
        recyclerView.adapter = myAdapter
    }

    private fun search(search: String) {
        recyclerViewList.clear()
        for (i in originalList.indices) {
            if (originalList[i].getText().equals(search)) {
                recyclerViewList.add(originalList[i])
            }
        }
        myAdapter!!.notifyDataSetChanged()
    }
}


