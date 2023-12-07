package com.themobilecoder.adventofcode.day7

enum class Card(val value: Int, val character: Char) {
    TWO(1, '2'),
    THREE(2, '3'),
    FOUR(3, '4'),
    FIVE(4, '5'),
    SIX(5, '6'),
    SEVEN(6, '7'),
    EIGHT(7, '8'),
    NINE(8, '9'),
    TEN(9, 'T'),
    JACK(10, 'J'),
    QUEEN(11, 'Q'),
    KING(12, 'K'),
    ACE(13, 'A');
}

fun Char.getCardFromChar(): Card {
    return Card.values().first { it.character == this }
}
