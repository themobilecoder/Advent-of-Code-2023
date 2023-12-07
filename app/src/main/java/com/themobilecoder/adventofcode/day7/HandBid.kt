package com.themobilecoder.adventofcode.day7

data class HandBid(
    val hand: String,
    val handType: HandType,
    val bid: Int,
) {
    enum class HandType(val value: Int) {
        HIGH(1),
        PAIR(2),
        TWO_PAIR(3),
        THREE_OF_A_KIND(4),
        FULL_HOUSE(5),
        FOUR_OF_A_KIND(6),
        FIVE_OF_A_KIND(7),
    }

}