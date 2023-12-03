package com.themobilecoder.adventofcode.day3

data class Point(val x: Int, val y: Int)

fun Point.top(): Point {
    return Point(
        x = x,
        y = y - 1
    )
}

fun Point.topLeft(): Point {
    return Point(
        x = x - 1,
        y = y - 1
    )
}

fun Point.left(): Point {
    return Point(
        x = x - 1,
        y = y
    )
}

fun Point.bottomLeft(): Point {
    return Point(
        x = x - 1,
        y = y + 1
    )
}

fun Point.bottom(): Point {
    return Point(
        x = x,
        y = y + 1
    )
}

fun Point.bottomRight(): Point {
    return Point(
        x = x + 1,
        y = y + 1
    )
}

fun Point.right(): Point {
    return Point(
        x = x + 1,
        y = y
    )
}

fun Point.topRight(): Point {
    return Point(
        x = x + 1,
        y = y - 1
    )
}
