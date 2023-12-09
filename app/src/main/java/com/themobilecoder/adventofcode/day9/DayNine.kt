package com.themobilecoder.adventofcode.day9

import com.themobilecoder.adventofcode.splitByNewLine

class DayNine {

    fun solveDayNinePartOne(input: String): Long {
        val lines = input.splitByNewLine()
        val inputLinesAsNumber = mutableListOf<List<Long>>()
        lines.forEach {
            val inputLineAsNumber = it.split(" ").map { num -> num.trim().toLong() }
            inputLinesAsNumber.add(inputLineAsNumber)
        }
        var prediction = 0L
        inputLinesAsNumber.forEach { inputLine ->
            val holder = mutableListOf(*inputLine.toTypedArray())
            val newHolder = mutableListOf<Long>()
            while (holder.filterNot { it == 0L }.isNotEmpty()) {
                for (i in 0 until (holder.size - 1)) {
                    val d = holder[i + 1] - holder[i]
                    newHolder.add(d)
                }
                prediction += holder[holder.size - 1]
                holder.clear()
                holder.addAll(newHolder.toTypedArray())
                newHolder.clear()
            }
        }
        return prediction
    }

    fun solveDayNinePartTwo(input: String): Long {
        val lines = input.splitByNewLine()
        val inputLinesAsNumber = mutableListOf<List<Long>>()
        lines.forEach {
            val inputLineAsNumber = it.split(" ").map { num -> num.trim().toLong() }
            inputLinesAsNumber.add(inputLineAsNumber)
        }
        var prediction = 0L
        inputLinesAsNumber.forEach { inputLine ->
            var initPrediction = inputLine[0]
            val holder = mutableListOf(*inputLine.toTypedArray())
            val newHolder = mutableListOf<Long>()
            var isPlus = false
            while (holder.filterNot { it == 0L }.isNotEmpty()) {
                for (i in 0 until (holder.size - 1)) {
                    val d = holder[i + 1] - holder[i]
                    newHolder.add(d)
                }
                if (isPlus) {
                    initPrediction += newHolder[0]
                } else {
                    initPrediction -= newHolder[0]
                }
                isPlus = !isPlus
                holder.clear()
                holder.addAll(newHolder.toTypedArray())
                newHolder.clear()
            }
            prediction += initPrediction
        }
        return prediction
    }
}