package com.example.android.helloworld2

fun main(){
    fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24){
        println(when {
            mood == "happy" && weather == "Sunny" -> "go for a walk"
            else -> "Stay home and read."
        })
    }
}