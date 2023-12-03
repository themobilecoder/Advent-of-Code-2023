package com.themobilecoder.adventofcode

import com.themobilecoder.adventofcode.day1.getFirstAndLastNumberAppended
import com.themobilecoder.adventofcode.day1.getFirstAndLastNumberAppendedIncludingWords
import junit.framework.TestCase.assertEquals
import org.junit.Test

class DayOneUtilKtTest {

    @Test
    fun `should getFirstAndLastNumberAppended`() {
        assertEquals(22, "one2".getFirstAndLastNumberAppended())
        assertEquals(11, "1two".getFirstAndLastNumberAppended())
        assertEquals(13, "1tw13threefouro".getFirstAndLastNumberAppended())
        assertEquals(11, "astwo1xx".getFirstAndLastNumberAppended())
    }

    @Test
    fun `should getFirstAndLastNumberAppendedIncludingWords`() {
        assertEquals(12, "one2".getFirstAndLastNumberAppendedIncludingWords())
        assertEquals(12, "1two".getFirstAndLastNumberAppendedIncludingWords())
        assertEquals(13, "1tw13threeo".getFirstAndLastNumberAppendedIncludingWords())
        assertEquals(21, "astwo1xx".getFirstAndLastNumberAppendedIncludingWords())
    }
}