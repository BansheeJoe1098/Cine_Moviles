package com.example.cine.models

data class Movies (
    val nombre:String,
    val img:Int,
    val exibicion : ArrayList<Exibicion>
    )