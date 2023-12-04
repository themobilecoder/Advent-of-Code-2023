package com.themobilecoder.adventofcode.day4

import junit.framework.TestCase.assertEquals
import org.junit.Test


class DayFourUtilsKtTest {

    @Test
    fun `should getWinningNumbersFromInput`() {
        assertEquals(
            5,
            TEST_INPUT_1.getWinningNumbersFromInput().size
        )
        assertEquals(
            setOf(41, 48, 83, 86, 17),
            TEST_INPUT_1.getWinningNumbersFromInput()
        )
        assertEquals(
            5,
            TEST_INPUT_2.getWinningNumbersFromInput().size
        )
        assertEquals(
            setOf(1, 21, 53, 59, 44),
            TEST_INPUT_2.getWinningNumbersFromInput()
        )
    }

    @Test
    fun `should getYourTicketNumbersFromInput`() {
        assertEquals(
            8,
            TEST_INPUT_1.getYourTicketNumbersFromInput().size
        )
        assertEquals(
            setOf(83, 86, 6, 31, 17, 9, 48, 53),
            TEST_INPUT_1.getYourTicketNumbersFromInput()
        )
    }

    @Test
    fun `should get game id`() {
        assertEquals(
            3,
            TEST_INPUT_2.getGameId()
        )
        assertEquals(
            3321,
            TEST_INPUT_3.getGameId()
        )
    }

    companion object {
        private val TEST_INPUT_1 = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
        """.trimIndent()
        private val TEST_INPUT_2 = """
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
        """.trimIndent()
        private val TEST_INPUT_3 = """
            Card 3321:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
        """.trimIndent()
    }

}