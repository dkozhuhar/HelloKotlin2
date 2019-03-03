package com.example.android.helloworld2.lesson5

fun main(args: Array<String>) {
    val b1 = Book("Steven Hawking", "Shortest history of time",2005)
    println("Here is your book ${b1.titleAndAuthor().first} written by ${b1.titleAndAuthor().second}")
    println("Here is your book ${b1.titleAndAuthorAndYear().first} written by ${b1.titleAndAuthorAndYear().second} in ${b1.titleAndAuthorAndYear().third}")
}

class Book (val author: String, val title: String, val year: Int) {
    fun titleAndAuthor(): Pair<String,String> {
        return title to author
    }
    fun titleAndAuthorAndYear() : Triple<String,String,Int>{
        return Triple(title,author,year)
    }
}