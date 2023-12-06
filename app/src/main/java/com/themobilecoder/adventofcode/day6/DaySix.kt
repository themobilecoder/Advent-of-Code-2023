package com.themobilecoder.adventofcode.day6

import com.themobilecoder.adventofcode.product
import com.themobilecoder.adventofcode.splitByNewLine

class DaySix {

    fun solveDaySixPartOne(input: String) : Int {
        val inputLines = input.splitByNewLine()
        val times = inputLines[0].split(":")[1].trim().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
        val distances = inputLines[1].split(":")[1].trim().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
        return List(times.size) { i ->
            Race(
                time = times[i],
                distance = distances[i],
            ).computeNumberOfCombinations()
        }.product()
    }

    fun solveDaySixPartTwo(input: String) : Long {
        val inputLines = input.splitByNewLine()
        val time = inputLines[0].split(":")[1].joinToLong()
        val distance = inputLines[1].split(":")[1].joinToLong()
        return computeNumberOfCombinationsOptimised(time, distance)
    }
}