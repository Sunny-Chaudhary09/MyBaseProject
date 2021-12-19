package com.example.mytest.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mytest.Data
import com.example.mytest.R
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    var id = ""
    var name = ""
    var salry = ""
    var age = ""
    var profile = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        id =  intent.getStringExtra("id")!!
        name = intent.getStringExtra("name")!!
        salry = intent.getStringExtra("salry")!!
        age = intent.getStringExtra("age")!!
        profile =  intent.getStringExtra("profile")!!
        val position = intent.getIntExtra("position", 0)

        Glide.with(this).load(profile)
            .circleCrop().into(profile_image)

        et_id.setText(id)
        et_name.setText(name)
        et_salary.setText(salry)
        et_age.setText(age)



        btn_submit.setOnClickListener {

            val pojoModel = Data(id,name,salry,age,profile,position.toString())
            et_id.getText().toString()
            et_name.getText().toString()
            et_salary.getText().toString()
            et_age.getText().toString()
            val returnIntent = Intent()
//            returnIntent.putExtra("result", pojoModel)
            returnIntent.putExtra("position", position)
            setResult(RESULT_OK, returnIntent)
            finish()


        }


    }


}

