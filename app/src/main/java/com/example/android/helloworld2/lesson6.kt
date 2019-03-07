package com.example.android.helloworld2

import java.text.FieldPosition
import kotlin.random.Random

fun main(args: Array<String>) {

    val game = Game()
    /*
    println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)

    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.dividedBy {it % 3})
    */
    while (true) {
        game.map.getDescription()
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine())
    }
}

enum class Directions(val p: Pair<String, List<Int>>) {
    NORTH("NORTH" to listOf(0,1)), SOUTH("SOUTH" to listOf(0,-1)), WEST("WEST" to listOf(-1,0)), EAST("EAST" to listOf(1,0)),
    START("START" to emptyList()), END("END" to emptyList())
}
class Game(var path: MutableList<String> = mutableListOf(Directions.START.p.first), val map: Map = Map()){
    val north = {
        map.changePosition(Directions.NORTH)
        path.add(Directions.NORTH.p.first)
        if (!map.isGoodPosition()) move(end)
        true
    }
    val south = {
        map.changePosition(Directions.SOUTH)
        path.add(Directions.SOUTH.p.first)
        if (!map.isGoodPosition()) move(end)
        true
    }
    val east = {
        map.changePosition(Directions.EAST)
        path.add(Directions.EAST.p.first)
        if (!map.isGoodPosition()) move(end)
        true
    }
    val west = {
        map.changePosition(Directions.WEST)
        path.add(Directions.WEST.p.first)
        if (!map.isGoodPosition()) move(end)
        true
    }
    val end = {

        path.add(Directions.END.p.first)
        println("Game Over: $path")
        path.clear()
        false
    }

    fun move(where: () -> Boolean) {
        where()
    }
    fun makeMove(string: String?) {

        when (string) {
            "n" -> move(north)
            "s" -> move(south)
            "w" -> move(west)
            "e" -> move(east)
            else -> move(end)
        }
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

class Map(val width: Int = 4, val height: Int = 4, val map: Array<BooleanArray> = Array(width){BooleanArray(height) { kotlin.random.Random.nextBoolean() }},
          var position: MutableList<Int> = mutableListOf(0,0) ) {
    init {
        map[0][0] = true
    }
    fun getTerrain(latitude: Int, longitude: Int) : String {
        return (
        when (map.getOrNull(latitude)?.getOrNull(longitude)) {
            true -> "normal tile"
            else -> "void"
        })
    }
    fun getDescription () {
        println("To the north is ${getTerrain(position[0],position[1] + 1)}")
        println("To the east is ${getTerrain(position[0] + 1,position[1])}")
        println("To the south is ${getTerrain(position[0],position[1] - 1)}")
        println("To the west is ${getTerrain(position[0] - 1,position[1])}")
    }
    fun changePosition(directions: Directions){
        for (i in 0..1){
            position[i] = directions.p.second[i] + position[i]
        }

    }
    fun isGoodPosition(): Boolean {
        return getTerrain(position[0],position[1]) == "normal tile"
    }
}

