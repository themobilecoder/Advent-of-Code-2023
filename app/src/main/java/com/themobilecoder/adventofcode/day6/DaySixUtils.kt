package com.themobilecoder.adventofcode.day6

fun Race.computeNumberOfCombinations() : Int {
    var combinations = 0
    for (speed in 1 until time) {
        val moveDuration = time - speed
        val distanceTraveled = moveDuration * speed
        if (distanceTraveled > distance) {
            combinations++
        }
    }
    return combinations
}

fun computeNumberOfCombinationsOptimised(time: Long, distance: Long) : Long {
    var combinations = 0L
    for (speed in 1 until time) {
        val moveDuration = time - speed
        val distanceTraveled = moveDuration * speed
        if (distanceTraveled > distance) {
            combinations++
        }
    }
    return combinations
}

fun String.joinToLong() : Long {
    return trim().filter { it != ' ' }.toLong()
}