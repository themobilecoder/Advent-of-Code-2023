package com.themobilecoder.adventofcode.day8

import com.themobilecoder.adventofcode.splitByNewLine

fun String.buildMapDirections(): Map<String, Pair<String, String>> {
    val lines = splitByNewLine().filter { it.isNotBlank() }.drop(1)
    val map = mutableMapOf<String, Pair<String, String>>()
    lines.forEach { line ->
        val key = line.split("=")[0].trim()
        val left = line.split("=")[1].split(",")[0].trim().filter { it.isLetterOrDigit() }
        val right = line.split("=")[1].split(",")[1].trim().filter { it.isLetterOrDigit() }
        map[key] = left to right
    }
    return map
}

fun String.getInstructions(): String {
    return splitByNewLine()[0].trim()
}

fun String.buildQueueOfStartingPoints(): List<String> {
    val keys = mutableListOf<String>()
    val lines = splitByNewLine().filter { it.isNotBlank() }.drop(1)
    lines.forEach { line ->
        val key = line.split("=")[0].trim()
        if (key.endsWith('A')) {
            keys.add(key)
        }
    }
    return keys
}

fun List<Long>.getLCM(): Long {
    var result = this[0]
    for (i in 1 until size) {
        result = getLCM(result, this[i])
    }
    return result
}

private fun getLCM(a: Long, b: Long): Long {
    val largerValue = if (a > b) a else b
    val maxLcm = a * b
    var lcm = largerValue
    while (lcm <= maxLcm) {
        if (lcm % a == 0L && lcm % b == 0L) {
            return lcm
        }
        lcm += largerValue
    }
    return maxLcm
}