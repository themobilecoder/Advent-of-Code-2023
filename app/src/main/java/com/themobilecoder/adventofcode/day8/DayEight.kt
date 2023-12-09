package com.themobilecoder.adventofcode.day8

class DayEight {

    fun solveDayEightPartOne(input: String): Int {
        val instructions = input.getInstructions()
        val map = input.buildMapDirections()
        var steps = 1
        var isLooping = true
        var currentKey = "AAA"
        while (isLooping) {
            for (i in instructions.indices) {
                if (instructions[i] == left) {
                    if (map[currentKey]?.first == correct) {
                        isLooping = false
                        break
                    } else {
                        currentKey = map[currentKey]?.first ?: ""
                    }
                } else if (instructions[i] == right) {
                    if (map[currentKey]?.second == correct) {
                        isLooping = false
                        break
                    } else {
                        currentKey = map[currentKey]?.second ?: ""
                    }
                }
                steps++
            }
        }
        return steps
    }

    fun solveDayEightPartTwo(input: String): Long {
        val instructions = input.getInstructions()
        val map = input.buildMapDirections()
        val keys = input.buildQueueOfStartingPoints()
        val listOfStepsToFindZ = mutableListOf<Long>()
        keys.forEach { key ->
            var tempSteps = 1L
            var tempKey = key
            var isLooping = true
            while (isLooping) {
                for (i in instructions.indices) {
                    if (instructions[i] == left) {
                        if (map.isLeftCorrectWithKey(tempKey)) {
                            isLooping = false
                            break
                        } else {
                            tempKey = map[tempKey]?.first ?: ""
                        }
                    } else if (instructions[i] == right) {
                        if (map.isRightCorrectWithKey(tempKey)) {
                            isLooping = false
                            break
                        } else {
                            tempKey = map[tempKey]?.second ?: ""
                        }
                    }
                    tempSteps++
                }
            }
            listOfStepsToFindZ.add(tempSteps)
        }
        return listOfStepsToFindZ.getLCM()
    }

    private fun Map<String, Pair<String, String>>.isLeftCorrectWithKey(key: String): Boolean {
        val map = this
        return map[key]?.first?.endsWith('Z') == true
    }

    private fun Map<String, Pair<String, String>>.isRightCorrectWithKey(key: String): Boolean {
        val map = this
        return map[key]?.second?.endsWith('Z') == true
    }


    private val correct = "ZZZ"
    private val left = 'L'
    private val right = 'R'

}