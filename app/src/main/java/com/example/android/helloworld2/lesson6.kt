package com.example.android.helloworld2

fun main(args: Array<String>) {
    val game = Game()
    println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)
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

fun List<Int>.div3(number: Int, -> {}){

}
