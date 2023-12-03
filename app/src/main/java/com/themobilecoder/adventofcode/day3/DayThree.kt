package com.themobilecoder.adventofcode.day3

class DayThree {

    fun solveDayThreePartOne(engineMap: EngineMap): Int {
        val numbers = mutableListOf<Int>()
        engineMap.engine.forEachIndexed { y, characters ->
            var x = 0
            while (x < characters.size) {
                val character = characters[x]
                if (character.isDigit()) {
                    var indexForNumber = x
                    val stringBuilder = StringBuilder()

                    //Get the whole number
                    while (indexForNumber < characters.size && characters[indexForNumber].isDigit()) {
                        stringBuilder.append(characters[indexForNumber])
                        indexForNumber++
                    }
                    val number = stringBuilder.toString().toInt()

                    //Check if number isPartNumber
                    val startIndex = x
                    val endIndexExclusive = indexForNumber
                    if (
                        isPartNumber(
                            engineMap = engineMap,
                            lineIndex = y,
                            numberStartIndex = startIndex,
                            numberEndIndexExclusive = endIndexExclusive
                        )
                    ) {
                        numbers.add(number)
                    }
                    x = endIndexExclusive
                } else {
                    x++
                }
            }
        }
        return numbers.sum()
    }

    fun solveDayThreePartTwo(engineMap: EngineMap): Int {
        val asteriskPoints = hashMapOf<Point, MutableList<Int>>()
        engineMap.engine.forEachIndexed { y, characters ->
            var x = 0
            while (x < characters.size) {
                val character = characters[x]
                if (character.isDigit()) {
                    var indexForNumber = x
                    val stringBuilder = StringBuilder()

                    //Get the whole number
                    while (indexForNumber < characters.size && characters[indexForNumber].isDigit()) {
                        stringBuilder.append(characters[indexForNumber])
                        indexForNumber++
                    }
                    val number = stringBuilder.toString().toInt()

                    //Get asterisk locations and the numbers attached to them
                    val startIndex = x
                    val endIndexExclusive = indexForNumber
                    val gearLocations = getGearsAttached(
                        engineMap = engineMap,
                        lineIndex = y,
                        numberStartIndex = startIndex,
                        numberEndIndexExclusive = endIndexExclusive
                    )
                    if (gearLocations.isNotEmpty()) {
                        gearLocations.forEach { point ->
                            if (asteriskPoints[point].isNullOrEmpty()) {
                                asteriskPoints[point] = mutableListOf()
                            }
                            val partNumbers = asteriskPoints[point]
                            partNumbers?.let {
                                it.add(number)
                                asteriskPoints[point] = it
                            }
                        }
                    }
                    x = endIndexExclusive
                } else {
                    x++
                }
            }
        }
        return asteriskPoints.filter { asteriskPoint ->
            asteriskPoint.value.size == 2
        }.map { gear ->
            gear.value[0] * gear.value[1]
        }.sum()
    }

}