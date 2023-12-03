package com.themobilecoder.adventofcode.day2

import com.themobilecoder.adventofcode.splitByNewLine

class DayTwo {

    fun solveDayTwoPartOne(input: String): Int {
        val lines = input.splitByNewLine()
        var sum = 0
        lines.forEach { line ->
            val score = line.getGameIdAsScore()
            val rgbSetsAsList = line.parseInputToRgbSetsAsList()
            var isValid = true
            rgbSetsAsList.forEach rgbSetsLoop@ { rgbSet ->
                val map = rgbSet.parseRgbToMap()
                if (
                    map.isGameImpossible(
                        maxRed = MAX_RED,
                        maxGreen = MAX_GREEN,
                        maxBlue = MAX_BLUE
                    )
                ) {
                    isValid = false
                    return@rgbSetsLoop
                }
            }
            if (isValid) {
                sum += score
            }
        }
        return sum
    }

    fun solveDayTwoPartTwo(input: String): Int {
        val lines = input.splitByNewLine()
        var sum = 0
        lines.forEach { line ->
            val rgbSetsAsList = line.parseInputToRgbSetsAsList()
            var maxRed = Int.MIN_VALUE
            var maxGreen = Int.MIN_VALUE
            var maxBlue = Int.MIN_VALUE
            rgbSetsAsList.forEach { rgbSet ->
                val map = rgbSet.parseRgbToMap()
                val redValue = map.getRedValue()
                if (redValue > maxRed) {
                    maxRed = redValue
                }
                val greenValue = map.getGreenValue()
                if (greenValue > maxGreen) {
                    maxGreen = greenValue
                }
                val blueValue = map.getBlueValue()
                if (blueValue > maxBlue) {
                    maxBlue = blueValue
                }
            }
            sum += (maxRed * maxGreen * maxBlue)
        }
        return sum
    }

    companion object {
        private const val MAX_RED = 12
        private const val MAX_GREEN = 13
        private const val MAX_BLUE = 14
    }


}