package com.themobilecoder.adventofcode

fun String.splitByNewLine() : List<String> {
    return split("\n")
}

fun Iterable<Int>.product(): Int {
    var product = 1
    for (element in this) {
        product *= element
    }
    return product
}