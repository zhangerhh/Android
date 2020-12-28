package com.example.myapplication_final.ui.city

data class City(
    val area_code: String,
    val city_code: String,
    val city_name: String,
    val ctime: String,
    val id: Int,
    val pid: Int,
    val post_code: String
){
    override fun toString(): String {
        return city_name
    }
}