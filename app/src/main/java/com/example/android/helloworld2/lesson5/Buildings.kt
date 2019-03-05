package com.example.android.helloworld2.lesson5

fun main(args: Array<String>) {
    Building(Wood()).build()
    isSmallBuilding(Building(Wood()))
    Building(Brick()).build()
    isSmallBuilding(Building(Brick()))
}

open class BaseBuildingMaterial(open val numberNeeded:Int = 1)
class Wood() : BaseBuildingMaterial(4)
class Brick(): BaseBuildingMaterial(8)

class Building<T: BaseBuildingMaterial>(val materials: T) {
    val baseMaterialsNeeded = 100
    var actualMaterialsNeeded = materials.numberNeeded * baseMaterialsNeeded
    fun build() {
        println("$actualMaterialsNeeded ${materials::class.simpleName} required" )
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("Small building")
    } else println("Big building")
}