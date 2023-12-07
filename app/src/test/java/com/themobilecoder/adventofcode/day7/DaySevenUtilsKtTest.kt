package com.themobilecoder.adventofcode.day7

import junit.framework.TestCase.assertEquals
import org.junit.Test


class DaySevenUtilsKtTest {

    @Test
    fun `should get hand bids correctly`() {
        assertEquals(
            5,
            TEST_INPUT_1.convertToHandBids().size
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.PAIR,
                bid = 765,
                hand = "32T3K"
            ),
            TEST_INPUT_1.convertToHandBids()[0]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.THREE_OF_A_KIND,
                bid = 684,
                hand = "T55J5"
            ),
            TEST_INPUT_1.convertToHandBids()[1]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.TWO_PAIR,
                bid = 28,
                hand = "KK677"
            ),
            TEST_INPUT_1.convertToHandBids()[2]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.TWO_PAIR,
                bid = 220,
                hand = "KTJJT"
            ),
            TEST_INPUT_1.convertToHandBids()[3]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.THREE_OF_A_KIND,
                bid = 483,
                hand = "QQQJA"
            ),
            TEST_INPUT_1.convertToHandBids()[4]
        )

    }

    @Test
    fun `should get hand bids with wildcard correctly`() {
        assertEquals(
            5,
            TEST_INPUT_1.convertToHandBidsWithWildCard().size
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.PAIR,
                bid = 765,
                hand = "32T3K"
            ),
            TEST_INPUT_1.convertToHandBidsWithWildCard()[0]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.FOUR_OF_A_KIND,
                bid = 684,
                hand = "T55J5"
            ),
            TEST_INPUT_1.convertToHandBidsWithWildCard()[1]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.TWO_PAIR,
                bid = 28,
                hand = "KK677"
            ),
            TEST_INPUT_1.convertToHandBidsWithWildCard()[2]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.FOUR_OF_A_KIND,
                bid = 220,
                hand = "KTJJT"
            ),
            TEST_INPUT_1.convertToHandBidsWithWildCard()[3]
        )
        assertEquals(
            HandBid(
                handType = HandBid.HandType.FOUR_OF_A_KIND,
                bid = 483,
                hand = "QQQJA"
            ),
            TEST_INPUT_1.convertToHandBidsWithWildCard()[4]
        )

    }

    @Test
    fun `should get hand type with card`() {
        assertEquals(
            HandBid.HandType.FIVE_OF_A_KIND,
            "JJJJT".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.FIVE_OF_A_KIND,
            "JJJJJ".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.FIVE_OF_A_KIND,
            "JJJTT".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.FOUR_OF_A_KIND,
            "JJJQT".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.PAIR,
            "123J4".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.FULL_HOUSE,
            "223J3".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.HIGH,
            "12345".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.TWO_PAIR,
            "11225".getHandTypeWithWildCard()
        )
        assertEquals(
            HandBid.HandType.THREE_OF_A_KIND,
            "QQJ12".getHandTypeWithWildCard()
        )
    }

    companion object {
        private val TEST_INPUT_1 = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
            QQQJA 483
        """.trimIndent()
    }
}