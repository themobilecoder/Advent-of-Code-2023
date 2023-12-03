package com.themobilecoder.adventofcode.day3

fun Char.isSymbol(): Boolean {
    return !this.isDigit() && this != '.'
}

fun Char.isAsterisk(): Boolean {
    return this == '*'
}

fun List<String>.buildEngineSchematic(): Array<Array<Char>> {
    return map { line ->
        line.map { it }.toTypedArray()
    }.toTypedArray()
}

fun isPartNumber(
    engineMap: EngineMap,
    lineIndex: Int,
    numberStartIndex: Int,
    numberEndIndexExclusive: Int,
): Boolean {
    var index = numberStartIndex
    while (index < numberEndIndexExclusive) {
        val currentPoint = Point(x = index, y = lineIndex)
        if (
            engineMap.getValue(currentPoint.top()).isSymbol() ||
            engineMap.getValue(currentPoint.topLeft()).isSymbol() ||
            engineMap.getValue(currentPoint.left()).isSymbol() ||
            engineMap.getValue(currentPoint.bottomLeft()).isSymbol() ||
            engineMap.getValue(currentPoint.bottom()).isSymbol() ||
            engineMap.getValue(currentPoint.bottomRight()).isSymbol() ||
            engineMap.getValue(currentPoint.right()).isSymbol() ||
            engineMap.getValue(currentPoint.topRight()).isSymbol()
        ) {
            return true
        }
        index++
    }
    return false
}

fun getGearsAttached(
    engineMap: EngineMap,
    lineIndex: Int,
    numberStartIndex: Int,
    numberEndIndexExclusive: Int,
): Set<Point> {
    var index = numberStartIndex
    val points = mutableSetOf<Point>()
    while (index < numberEndIndexExclusive) {
        val currentPoint = Point(x = index, y = lineIndex)
        print(currentPoint)
        if (engineMap.getValue(currentPoint.top()).isAsterisk()) {
            points.add(currentPoint.top())
        }
        if (engineMap.getValue(currentPoint.topLeft()).isAsterisk()) {
            points.add(currentPoint.topLeft())
        }
        if (engineMap.getValue(currentPoint.left()).isAsterisk()) {
            points.add(currentPoint.left())
        }
        if (engineMap.getValue(currentPoint.bottomLeft()).isAsterisk()) {
            points.add(currentPoint.bottomLeft())
        }
        if (engineMap.getValue(currentPoint.bottom()).isAsterisk()) {
            points.add(currentPoint.bottom())
        }
        if (engineMap.getValue(currentPoint.bottomRight()).isAsterisk()) {
            points.add(currentPoint.bottomRight())
        }
        if (engineMap.getValue(currentPoint.right()).isAsterisk()) {
            points.add(currentPoint.right())
        }
        if (engineMap.getValue(currentPoint.topRight()).isAsterisk()) {
            points.add(currentPoint.topRight())
        }
        index++
    }
    return points
}