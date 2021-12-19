package com.example.mytest

import com.google.gson.annotations.SerializedName


data class DataClass(
    val `data`: List<Data>,
    val message: String,
    val status: String
)

data class Data(
        val employee_age: String,
        val employee_name: String,
        val employee_salary: String,
        val id: String,
        val profile_image: String,

        var name: String = ""

)















