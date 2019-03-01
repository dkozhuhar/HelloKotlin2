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
        words = words + 250
    }
}