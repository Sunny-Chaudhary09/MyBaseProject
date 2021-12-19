package com.example.mytest.models

class TestModel : ArrayList<TestModelItem>()

data class TestModelItem(
    val category: String,
    val desc: String,
    val imageUrl: String,
    val name: String
)