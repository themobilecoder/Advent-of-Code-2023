package com.themobilecoder.adventofcode.day3

import com.themobilecoder.adventofcode.splitByNewLine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test


class DayThreeUtilsKtTest {

    @Test
    fun `isSymbol should be correct`() {
        assertFalse('.'.isSymbol())
        assertFalse('1'.isSymbol())
        assertTrue('+'.isSymbol())
        assertTrue('$'.isSymbol())
        assertTrue('+'.isSymbol())
        assertTrue('*'.isSymbol())
    }

    @Test
    fun `should build map correctly with buildEngineSchematic`() {
        val input = """
            467..114..
            ...*......
        """.trimIndent().splitByNewLine()
        val engineSchematic = input.buildEngineSchematic()
        assertEquals(2, engineSchematic.size)
        assertEquals(10, engineSchematic[0].size)
        assertEquals(10, engineSchematic[1].size)

        assertEquals(engineSchematic[0][0], '4')
        assertEquals(engineSchematic[0][1], '6')
        assertEquals(engineSchematic[1][0], '.')
        assertEquals(engineSchematic[1][3], '*')
    }

    @Test
    fun `should correctly check if partNumber`() {
        val engineMap = EngineMap(DAY_3_PART_1_TEST_INPUT_1)
        assertTrue(
            isPartNumber(
                engineMap = engineMap,
                lineIndex = 0,
                numberStartIndex = 0,
                numberEndIndexExclusive = 2
            )
        )
        assertFalse(
            isPartNumber(
                engineMap = engineMap,
                lineIndex = 0,
                numberStartIndex = 5,
                numberEndIndexExclusive = 7
            )
        )
    }

    @Test
    fun `should return correct value from getGearsAttached`() {
        val engineMap = EngineMap(DAY_3_PART_1_TEST_INPUT_2)

        val pointsOfGearsAttached = getGearsAttached(
            engineMap = engineMap,
            lineIndex = 0,
            numberStartIndex = 0,
            numberEndIndexExclusive = 3
        )
        assertEquals(1, pointsOfGearsAttached.size)

        val pointsOfGearsAttachedTwo = getGearsAttached(
            engineMap = engineMap,
            lineIndex = 0,
            numberStartIndex = 5,
            numberEndIndexExclusive = 8
        )
        assertEquals(2, pointsOfGearsAttachedTwo.size)
    }

    companion object {
        private val DAY_3_PART_1_TEST_INPUT_1 = """
            467..114..
            ...*......
        """.trimIndent()
        private val DAY_3_PART_1_TEST_INPUT_2 = """
            467*.114*.
            .......*..
        """.trimIndent()
    }
}