package com.example.android.helloworld2

import java.lang.Math.random
import java.util.*

fun main(args: Array<String>) {
    /*
    println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecoration = false))
    println(canAddFish(9.0, listOf(1,1,3), 3))
    println(canAddFish(10.0, listOf(), 7, true))

    var fortuneToTell: String = getFortuneCookie()
    println(fortuneToTell)
    while(!fortuneToTell.contains("Take it easy")){

        fortuneToTell = getFortuneCookie()
        println(fortuneToTell)
    }
*/
    repeat(10){
        gamePlay(rollDice2(7))
    }
}

fun dayOfWeek(){
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when (day){
        1 -> println("Today is Sunday")
        2 -> println("Today is Monday")
        3 -> println("Today is Tuesday")
        4 -> println("Today is Wednesday")
        5 -> println("Today is Thursday")
        6 -> println("Today is Friay")
        7 -> println("Today is Saturday")
        else ->  println("No day today")
    }
}

fun getFortuneCookie(birthday: Int = getBirthday()): String {
    val fortunes = listOf("You will have a great day!","Things will go well for you today.","Enjoy a wonderful day of success.","Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.","Take it easy and enjoy life!","Treasure your friends because they are your greatest fortune.")


    return fortunes[when (birthday) {
        in 5..7 -> 0
        15 or 29 -> 1
        else -> birthday % fortunes.size
    }]
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecoration: Boolean = true): Boolean{
    return tankSize * (1.0 - 0.2.times(if (hasDecoration) 1 else 0)) >= fishSize + currentFish.sum()
}
val rollDice = {numberOfSides: Int -> if (numberOfSides == 0) 0 else random().times(numberOfSides).toInt().plus(1)}

val rollDice2: (Int) -> Int = {sides -> Random().nextInt(sides) + 1}

fun gamePlay(diceRoll: Int = rollDice(6)){
    println(diceRoll)
}