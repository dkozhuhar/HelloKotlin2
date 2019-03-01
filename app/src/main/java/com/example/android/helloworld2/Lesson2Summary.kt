package com.example.android.helloworld2

import java.time.LocalDateTime


fun main(){
    doINeedFeedIt(calculateTime(LocalDateTime.now(),8),19.0)
    doINeedTakeItForWalk(15)
}
fun doINeedTakeItForWalk(hour: Int, animal: String = "dog",  isOutside: Boolean = false) {
    println(when {
        !isOutside && (hour in 20..24 || hour in 7..9) -> "Take a $animal for a walk"
        else -> "Relax"
    })
}
fun doINeedFeedIt(lastFeedTime: LocalDateTime, weight: Double = 21.0 ) {
    if (weight < 20.0 && lastFeedTime < LocalDateTime.now().minusHours(6)) println("Feed it !")
    else println("Do not feed it")
}

val calculateTime: (LocalDateTime, Long) -> LocalDateTime = { time, hours ->
    time.minusHours(hours)
}