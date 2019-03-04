package com.example.android.helloworld2.lesson5

fun main(args: Array<String>) {

    val building1 = Building(Wood())
    building1.build()
    val building2 = Building(Brick())
    building2.build()
}

open class BaseBuildingMaterial(var numberNeeded:Int = 1)
class Wood() : BaseBuildingMaterial(4)
class Brick(): BaseBuildingMaterial(8)

class Building<T: BaseBuildingMaterial>(val materials: T) {
    val baseMaterialsNeeded = 100
    var actualMaterialsNeeded = materials.numberNeeded * baseMaterialsNeeded
    fun build() {
        println("$actualMaterialsNeeded ${materials::class.simpleName} required" )
    }
}