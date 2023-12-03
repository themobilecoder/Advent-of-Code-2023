package com.themobilecoder.adventofcode.day3

import com.themobilecoder.adventofcode.splitByNewLine

class EngineMap(input: String) {
    val engine: Array<Array<Char>> = input.splitByNewLine().buildEngineSchematic()
    fun getValue(point: Point): Char {
        return try {
            engine[point.y][point.x]
        } catch (_: Exception) {
            '.'
        }
    }
}