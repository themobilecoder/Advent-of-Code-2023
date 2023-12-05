package com.themobilecoder.adventofcode.day5

import junit.framework.TestCase.assertEquals
import org.junit.Test

class DayFiveUtilsKtTest {

    @Test
    fun `should get seeds to be planted`() {
        assertEquals(
            listOf(79u, 14u, 55u, 13u),
            TEST_INPUT_1.getSeedsToBePlanted()
        )
    }

    @Test
    fun `should get seed pairs to be planted`() {
        assertEquals(
            2,
            TEST_INPUT_1.getSeedPairsToBePlanted().size
        )
        assertEquals(
            SeedPair(
                start = 79u,
                range = 14u
            ),
            TEST_INPUT_1.getSeedPairsToBePlanted()[0]
        )
        assertEquals(
            SeedPair(
                start = 55u,
                range = 13u
            ),
            TEST_INPUT_1.getSeedPairsToBePlanted()[1]
        )
    }

    @Test
    fun `should get map given map name`() {
        assertEquals(
            2,
            TEST_INPUT_1.getMapAsConversionObjectsFromConversionType(ConversionType.SEED_TO_SOIL).size
        )
        assertEquals(
            listOf(
                ConversionObject(
                    destination = 50u,
                    source = 98u,
                    range = 2u
                ),
                ConversionObject(
                    destination = 52u,
                    source = 50u,
                    range = 48u
                ),
            ),
            TEST_INPUT_1.getMapAsConversionObjectsFromConversionType(ConversionType.SEED_TO_SOIL)
        )
    }

    companion object {
        private val TEST_INPUT_1 = """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
        """.trimIndent()
    }

}