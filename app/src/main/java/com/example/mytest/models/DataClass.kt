package com.example.mytest


data class DataClass(
    val `data`: List<Data>,
    val message: String,
    val status: String,

)

data class Data(
    val employee_age: String,
    val employee_name: String,
    val employee_salary: String,
    val id: String,
    val profile_image: String,
    var name: String = "",
    var isSelected: Boolean = false



)

















