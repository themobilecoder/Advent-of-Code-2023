package com.themobilecoder.adventofcode.day4

fun String.getWinningNumbersFromInput() : Set<Int> {
    return split(":")[1].split("|")[0].trim().split(" ").filter {
        it.isNotEmpty()
    }.map {
        it.toInt()
    }.toSet()
}

fun String.getYourTicketNumbersFromInput() : Set<Int> {
    return split(":")[1].split("|")[1].split(" ").filter {
        it.isNotEmpty()
    }.map {
        it.toInt()
    }.toSet()
}

fun String.getGameId() : Int {
    val cardName = split(":")[0]
    var indexOfDigit = 0
    while(indexOfDigit < cardName.length) {
        if (cardName[indexOfDigit].isDigit()) {
            break
        }
        indexOfDigit++
    }
    return cardName.substring(indexOfDigit).toInt()
}