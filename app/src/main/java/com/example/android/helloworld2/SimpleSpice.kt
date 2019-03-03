package com.example.android.helloworld2

class SimpleSpice {
    val name: String = "curry"
    val spiciness: String = "mild"
    var heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
        set(value) {value}
}

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "hot" -> 10
            else -> 0
        }
    init {
        println("Name of spice: $name, spiciness: $spiciness, how hot it is: $heat")
    }
}

open class Book(val title: String, val author: String){
    private var currentPage: Int = 1
    open fun readPage() {
        currentPage++
    }
}

class eBook(title: String, author: String, val format: String = "text") : Book(title, author) {
    private var words: Int = 0
    override fun readPage(){
        words += 250
    }
}

sealed class Spice2(val name: String, val spiciness: String = "mild") : SpiceColor {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "hot" -> 10
            else -> 0
        }
    abstract fun prepareSpice()
    init {
        println("Name of spice: $name, spiciness: $spiciness, how hot it is: $heat")
    }
}

class Curry(spiciness: String) : Spice2("curry", spiciness), Grinder {
    override fun prepareSpice() {
        grind()
    }
    override val color = YellowSpiceColor.color
}
interface Grinder {
    fun grind() {}
}
interface SpiceColor {
    val color: Color
}
object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}
data class SpiceContainer(val spice : Spice2){
    val label = spice.name
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00)
}