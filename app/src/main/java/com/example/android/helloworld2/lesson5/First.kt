package com.example.android.helloworld2.lesson5


import kotlin.random.Random
import kotlin.random.nextInt

fun main(args: Array<String>) {

    val b1 = Book("Steven Hawking", "Shortest history of time",2005, 200)
    val puppy = Puppy()
    while (b1.pages > 1) {
        puppy.playWIthBook(b1)
        println(b1.pages)
    }
    //println("Here is your book ${b1.titleAndAuthor().first} written by ${b1.titleAndAuthor().second}")
    //println("Here is your book ${b1.titleAndAuthorAndYear().first} written by ${b1.titleAndAuthorAndYear().second} in ${b1.titleAndAuthorAndYear().third}")
    //b1.printUrl()
    /*
    val allBooks = setOf("Hamlet","Othello", "King Lear", "Macbeth")
    val library = allBooks.associate { it to  "William Shakespeare"}
    val moreBooks = mutableMapOf("A briefer history of time" to "Steven Hawking")
    moreBooks.getOrPut("Brief history of time")   {"Steven Hawking"}
    //println(library.any {it.key.contains("Hamlet")})
    //println(moreBooks)
    */
}

class Book (val author: String, val title: String, val year: Int, var pages: Int) {
    fun titleAndAuthor(): Pair<String,String> {
        return title to author
    }
    fun titleAndAuthorAndYear() : Triple<String,String,Int>{
        return Triple(title,author,year)
    }
    fun canBorrow(borrowedBooks: Int): Boolean {
        return borrowedBooks < borrowLimit
    }
    companion object {
        const val BASE_URL = "https://classroom.udacity.com/"
    }
    fun printUrl(){
        println("$BASE_URL$title.html")
    }
}
const val borrowLimit = 5
fun Book.getWeight() = pages * 1.5
fun Book.tornPages(numberOfTornPages: Int) {
    pages -= numberOfTornPages
}
class Puppy(){
    fun playWIthBook(book: Book) {
        //val numberOfPagesToTorn = Random.nextInt(1..book.pages)
        //println(numberOfPagesToTorn)
        book.tornPages(Random.nextInt(1..book.pages))
    }
}