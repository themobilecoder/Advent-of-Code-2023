package com.themobilecoder.adventofcode.day7

enum class CardWithWildCard(val value: Int, val character: Char) {
    JACK(0, 'J'),
    TWO(1, '2'),
    THREE(2, '3'),
    FOUR(3, '4'),
    FIVE(4, '5'),
    SIX(5, '6'),
    SEVEN(6, '7'),
    EIGHT(7, '8'),
    NINE(8, '9'),
    TEN(9, 'T'),
    QUEEN(10, 'Q'),
    KING(11, 'K'),
    ACE(12, 'A');
}

fun Char.getCardWithWildCardFromChar(): CardWithWildCard {
    return CardWithWildCard.values().first { it.character == this }
}
