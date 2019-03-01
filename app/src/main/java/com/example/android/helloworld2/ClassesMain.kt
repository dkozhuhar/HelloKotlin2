package com.example.android.helloworld2

fun main (args: Array<String>) {
    val simpleSpice =  SimpleSpice()
    println("Name: ${simpleSpice.name}, heat: ${simpleSpice.heat}")
    val spices = listOf(Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("chili","hot"))
    val lessSpicy = spices.filter { it.heat < 6 }
    lessSpicy.forEach{ println(it.name)}
}
fun makeSalt() {
    Spice("Salt","salty")
}