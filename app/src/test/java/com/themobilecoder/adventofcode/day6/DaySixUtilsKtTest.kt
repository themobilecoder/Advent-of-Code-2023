package com.themobilecoder.adventofcode.day6

import junit.framework.TestCase.assertEquals
import org.junit.Test

class DaySixUtilsKtTest {

    @Test
    fun `should compute combinations or a race`() {
//        assertEquals(
//            4,
//            Race(
//                time = 7,
//                distance = 9
//            ).computeNumberOfCombinations()
//        )
//        assertEquals(
//            8,
//            Race(
//                time = 15,
//                distance = 40
//            ).computeNumberOfCombinations()
//        )
        assertEquals(
            9,
            Race(
                time = 30,
                distance = 200
            ).computeNumberOfCombinations()
        )

    }
}