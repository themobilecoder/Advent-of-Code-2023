package com.themobilecoder.adventofcode.day2

fun String.getGameIdAsScore(): Int {
    val indexOfColon = indexOf(":")
    return substring(0, indexOfColon).filter {
        it.isDigit()
    }.toInt()
}

fun String.parseInputToRgbSetsAsList(): List<String> {
    val indexOfColon = indexOf(":")
    return substring(indexOfColon + 1).trim().split(";").map { it.trim() }
}

fun String.parseRgbToMap(): Map<String, Int> {
    val colorPairs = split(",")
    val colorMap = mutableMapOf<String, Int>()
    colorPairs.forEach {
        val items = it.trim().split(" ")
        colorMap[items[1]] = items[0].toInt()
    }
    return colorMap
}

fun Map<String, Int>.isGameImpossible(maxRed: Int, maxGreen: Int, maxBlue: Int): Boolean {
    return ((this[RED] ?: 0) > maxRed ||
            (this[BLUE] ?: 0) > maxBlue ||
            (this[GREEN] ?: 0) > maxGreen)
}

fun Map<String, Int>.getRedValue() : Int {
    return this[RED] ?: Int.MIN_VALUE
}

fun Map<String, Int>.getGreenValue() : Int {
    return this[GREEN] ?: Int.MIN_VALUE
}

fun Map<String, Int>.getBlueValue() : Int {
    return this[BLUE] ?: Int.MIN_VALUE
}