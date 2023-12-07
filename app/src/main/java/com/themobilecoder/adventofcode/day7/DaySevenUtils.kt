package com.themobilecoder.adventofcode.day7

import com.themobilecoder.adventofcode.splitByNewLine

fun String.convertToHandBids(): List<HandBid> {
    return splitByNewLine().map {
        val line = it.split(" ")
        val hand = line[0]
        val bid = line[1].toInt()
        HandBid(
            hand = hand,
            bid = bid,
            handType = hand.getHandType()
        )
    }
}

fun String.convertToHandBidsWithWildCard(): List<HandBid> {
    return splitByNewLine().map {
        val line = it.split(" ")
        val hand = line[0]
        val bid = line[1].toInt()
        HandBid(
            hand = hand,
            bid = bid,
            handType = hand.getHandTypeWithWildCard()
        )
    }
}

fun String.getHandType(): HandBid.HandType {
    val mapOfValues = mutableMapOf<Char, Int>()
    this.forEach {
        if (mapOfValues.contains(it)) {
            mapOfValues[it] = (mapOfValues[it] ?: 0) + 1
        } else {
            mapOfValues[it] = 1
        }
    }
    val values = mapOfValues.values
    return if (values.contains(5)) {
        HandBid.HandType.FIVE_OF_A_KIND
    } else if (values.contains(4)) {
        HandBid.HandType.FOUR_OF_A_KIND
    } else if (values.contains(3) && values.contains(2)) {
        HandBid.HandType.FULL_HOUSE
    } else if (values.contains(3)) {
        HandBid.HandType.THREE_OF_A_KIND
    } else if (values.filter { it == 2 }.size == 2) {
        HandBid.HandType.TWO_PAIR
    } else if (values.contains(2)) {
        HandBid.HandType.PAIR
    } else {
        HandBid.HandType.HIGH
    }
}

fun String.getHandTypeWithWildCard(): HandBid.HandType {
    val mapOfValues = mutableMapOf<Char, Int>()
    this.forEach {
        if (mapOfValues.contains(it)) {
            mapOfValues[it] = (mapOfValues[it] ?: 0) + 1
        } else {
            mapOfValues[it] = 1
        }
    }
    if (mapOfValues.contains('J') && mapOfValues['J'] != 5) {
        val cardWithMaxValue = mapOfValues.filter { it.key != 'J' }.maxBy { it.value }
        mapOfValues[cardWithMaxValue.key] =
            (mapOfValues[cardWithMaxValue.key] ?: 0) + (mapOfValues['J'] ?: 0)
        mapOfValues['J'] = 0
    }
    val values = mapOfValues.values
    return if (values.contains(5)) {
        HandBid.HandType.FIVE_OF_A_KIND
    } else if (values.contains(4)) {
        HandBid.HandType.FOUR_OF_A_KIND
    } else if (values.contains(3) && values.contains(2)) {
        HandBid.HandType.FULL_HOUSE
    } else if (values.contains(3)) {
        HandBid.HandType.THREE_OF_A_KIND
    } else if (values.filter { it == 2 }.size == 2) {
        HandBid.HandType.TWO_PAIR
    } else if (values.contains(2)) {
        HandBid.HandType.PAIR
    } else {
        HandBid.HandType.HIGH
    }
}

fun compareCard(c: Char, c2: Char): Int {
    return c.getCardFromChar().value - c2.getCardFromChar().value
}

fun compareCardWithWildCard(c: Char, c2: Char): Int {
    return c.getCardWithWildCardFromChar().value - c2.getCardWithWildCardFromChar().value
}