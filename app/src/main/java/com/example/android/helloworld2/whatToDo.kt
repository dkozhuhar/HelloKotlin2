package com.example.android.helloworld2

fun main(){
    fun whatShouldIDoToday(mood: String = getMood(), weather: String = "sunny", temperature: Int = 24){
        println(when {
            isGoodWeather(mood, weather) -> "go for a walk"
            isBadWeather(mood, weather, temperature) -> "stay in bed"
            isHotWeather(temperature) -> "go swimming"
            isGamingWeather(mood, weather) -> "play video games"
            else -> "Stay home and read."
        })
    }
    whatShouldIDoToday()
}
fun isGamingWeather(mood: String, weather: String) = mood == "sad" && weather == "rainy"
fun isGoodWeather(mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun isBadWeather(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isHotWeather(temperature: Int) = temperature > 35

fun getMood(): String {
    println("How are you feeling?")
    return readLine()!!
}