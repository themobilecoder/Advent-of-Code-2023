package com.themobilecoder.adventofcode.day4

import com.themobilecoder.adventofcode.splitByNewLine

class DayFour {

    fun solveDayFourPartOne(input: String) : Int {
        val cards = input.splitByNewLine()
        var sumOfPoints = 0
        cards.forEach { card ->
            val winningNumbers = card.getWinningNumbersFromInput()
            val yourNumbers = card.getYourTicketNumbersFromInput()
            val points = yourNumbers.fold(0) { totalCount, number ->
                if (winningNumbers.contains(number)) {
                    if (totalCount == 0) {
                        1
                    } else {
                        totalCount * 2
                    }
                } else {
                    totalCount
                }
            }
            sumOfPoints += points
        }
        return sumOfPoints
    }

    fun solveDayFourPartTwo(input: String) : Int {
        val cards = input.splitByNewLine()
        val gameCardsCopiesMap = mutableMapOf<Int, Int>()
        for (i in 1..cards.size) {
            gameCardsCopiesMap[i] = 1
        }
        cards.forEach { card ->
            val winningNumbers = card.getWinningNumbersFromInput()
            val yourNumbers = card.getYourTicketNumbersFromInput()
            val gameId = card.getGameId()
            val countOfCardsBelowToCopy = yourNumbers.fold(0) { totalCount, number ->
                if (winningNumbers.contains(number)) {
                    (totalCount + 1)
                } else {
                    totalCount
                }
            }
            for (i in gameId + 1 .. gameId + countOfCardsBelowToCopy) {
                if (gameCardsCopiesMap.contains(i)) {
                    val originalValue = gameCardsCopiesMap[i] ?: 1
                    gameCardsCopiesMap[i] = (originalValue + (gameCardsCopiesMap[gameId] ?: 1))
                }
            }
        }
        return gameCardsCopiesMap.values.sum()
    }
}