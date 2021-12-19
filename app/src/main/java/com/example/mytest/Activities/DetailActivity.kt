package com.example.mytest.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytest.Data
import com.example.mytest.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_view.*


class DetailActivity : AppCompatActivity() {

    var profile = String
    var id = String
    var name = String
    var salry = String
    var age = String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val intent = intent

        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val salry = intent.getStringExtra("salry")
        val age = intent.getStringExtra("age")
        val profile = intent.getStringExtra("profile")
        val position = intent.getIntExtra("position", 0)

        employe_id.text = id
        employe_name.text = name
        employe_salry.text = salry
        employe_id.text = age

        btn_submit.setOnClickListener {


            val pojoModel = Data(id.toString(),name.toString(),salry.toString(),age.toString(),profile.toString())
//            pojoModel.setEmployeeAge(empage.getText().toString())
//            pojoModel.setEmployeeName(employeename.getText().toString())
//            pojoModel.setEmployeeSalary(empsalary.getText().toString())
//            pojoModel.setProfileImage(profile)

            val returnIntent = Intent()
            returnIntent.putExtra("result", true)
            returnIntent.putExtra("position", position)
//                    returnIntent.putExtra("result",new Gson().toJson(returnIntent));
            //                    returnIntent.putExtra("result",new Gson().toJson(returnIntent));
            setResult(RESULT_OK, returnIntent)
            finish()

        }


    }


}