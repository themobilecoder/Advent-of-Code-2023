package com.themobilecoder.adventofcode.day1

fun String.getFirstAndLastNumberAppended(): Int {
    val digitString = filter {
        it.isDigit()
    }
    return if (digitString.isNotEmpty()) {
        "${getFirstDigit()}${getLastDigit()}".toInt()
    } else {
        0
    }
}

fun String.getFirstAndLastNumberAppendedIncludingWords(): Int {
    return "${getFirstDigitOrWordNumberOfLine()}${getLastDigitOrWordNumberOfLine()}".toInt()
}

private fun String.getFirstDigit() : String {
    return first { it.isDigit() }.toString()
}

private fun String.getLastDigit() : String {
    return last { it.isDigit() }.toString()
}

private fun String.isDigitWord() : Boolean {
    numbersInWords.forEach { numberInWord ->
        try {
            if (this.lowercase().substring(0, numberInWord.length) == numberInWord) {
                return true
            }
        } catch (_: Exception) { }
    }
    return false
}

private fun String.extractDigitWord() : String {
    numbersInWords.forEach { numberInWord ->
        try {
            if (this.lowercase().substring(0, numberInWord.length) == numberInWord) {
                return numberInWord
            }
        } catch (_: Exception) { }
    }
    return ""
}

private fun String.toDigitString() : String {
    return when(this.lowercase()) {
        "one" -> "1"
        "two" -> "2"
        "three" -> "3"
        "four" -> "4"
        "five" -> "5"
        "six" -> "6"
        "seven" -> "7"
        "eight" -> "8"
        "nine" -> "9"
        else -> "0"
    }
}

private fun String.getFirstDigitOrWordNumberOfLine() : String {
    this.forEachIndexed { idx, c ->
        if (c.isDigit()) {
            return c.toString()
        } else if (substring(idx).isDigitWord()) {
            return substring(idx).extractDigitWord().toDigitString()
        }
    }
    return ""
}

private fun String.getLastDigitOrWordNumberOfLine() : String {
    for (idx in this.indices.reversed()) {
        val c = this[idx]
        if (c.isDigit()) {
            return c.toString()
        } else if (substring(idx).isDigitWord()) {
            return substring(idx).extractDigitWord().toDigitString()
        }
    }
    return ""
}

private val numbersInWords = listOf(
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
)
