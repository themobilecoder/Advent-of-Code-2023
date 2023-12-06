package com.themobilecoder.adventofcode.day6

import junit.framework.TestCase.assertEquals
import org.junit.Test

class DaySixTest {

    private val daySix = DaySix()

    @Test
    fun `should solve day 6 part 1`() {
        assertEquals(
            4,
            daySix.solveDaySixPartOne(DAY_6_PART_1_TEST_INPUT_1)
        )
        assertEquals(
            288,
            daySix.solveDaySixPartOne(DAY_6_PART_1_TEST_INPUT_2)
        )
        assertEquals(
            128700,
            daySix.solveDaySixPartOne(DAY_6_PART_1_ACTUAL_INPUT)
        )
    }

    @Test
    fun `should solve day 6 part 2`() {
        assertEquals(
            71503,
            daySix.solveDaySixPartTwo(DAY_6_PART_1_TEST_INPUT_2)
        )
        assertEquals(
            39594072,
            daySix.solveDaySixPartTwo(DAY_6_PART_1_ACTUAL_INPUT)
        )
    }

    companion object {
        private val DAY_6_PART_1_TEST_INPUT_1 = """
            Time:      7
            Distance:  9
        """.trimIndent()
        private val DAY_6_PART_1_TEST_INPUT_2 = """
            Time:      7  15   30
            Distance:  9  40  200
        """.trimIndent()
        private val DAY_6_PART_1_ACTUAL_INPUT = """
            Time:        58     99     64     69
            Distance:   478   2232   1019   1071
        """.trimIndent()
    }
}