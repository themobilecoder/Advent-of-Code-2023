package com.themobilecoder.adventofcode.day2

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test


class DayTwoUtilsKtTest {

    @Test
    fun `should get id`() {
        assertEquals(
            2,
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
                .getGameIdAsScore()
        )
    }

    @Test
    fun `should parse input to RGB sets`() {
        val result = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
            .parseInputToRgbSetsAsList()
        assertEquals("1 blue, 2 green", result[0])
        assertEquals("3 green, 4 blue, 1 red", result[1])
        assertEquals("1 green, 1 blue", result[2])
//        assertEquals("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue", result)
    }

    @Test
    fun `should parse rgb to map`() {
        val map = "3 blue, 4 red".parseRgbToMap()
        assertTrue(map.containsKey("blue"))
        assertEquals(3, map["blue"])
        assertEquals(4, map["red"])
    }

}