package com.themobilecoder.adventofcode.day1

import com.themobilecoder.adventofcode.splitByNewLine

class DayOne {

    fun solveDayOnePartOne(input: String): Int {
        val lines = input.splitByNewLine()
        var sum = 0
        lines.forEach {  line ->
            sum += line.getFirstAndLastNumberAppended()
        }
        return sum
    }

    fun solveDayOnePartTwo(input: String) : Int {
        val lines = input.splitByNewLine()
        var sum = 0
        lines.forEach { line ->
            sum += line.getFirstAndLastNumberAppendedIncludingWords()
        }
        return sum
    }



}