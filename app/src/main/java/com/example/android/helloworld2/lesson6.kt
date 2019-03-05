package com.example.android.helloworld2

fun main(args: Array<String>) {
    /*
    val game = Game()
    println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)
    */
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.dividedBy {it % 3})
}



enum class Directions {
    NORTH, SOUTH, WEST, EAST, START, END
}
class Game(var path: MutableList<Directions> = mutableListOf(Directions.START)){
    val north = {path.add(Directions.NORTH)}
    val south = {path.add(Directions.SOUTH)}
    val east = {path.add(Directions.EAST)}
    val west = {path.add(Directions.WEST)}
    val end = {
        path.add(Directions.END)
        println("Game Over: $path")
        path.clear()
        false
    }
}

fun List<Int>.dividedBy (block:(Int) -> Int): List<Int> {
        val listdividedBy = mutableListOf<Int>()
        for (element in this) {
            if (block(element) == 0) {
                listdividedBy.add(element)
            }
        }
        return listdividedBy
}

