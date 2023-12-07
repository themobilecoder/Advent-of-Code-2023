package com.themobilecoder.adventofcode.day7

class DaySeven {

    fun solveDaySevenPartOne(input: String): Int {
        val handBids = input.convertToHandBids()
        val sorted = handBids.sortedWith { t, t2 ->
            val tValue = t.handType.value
            val t2Value = t2.handType.value
            if (tValue - t2Value == 0) {
                var i = 0
                var result = 0
                while (i < 5) {
                    result = compareCard(t.hand[i], t2.hand[i])
                    if (result == 0) {
                        i++
                    } else {
                        break
                    }
                }
                result
            } else {
                tValue - t2Value
            }
        }
        var totalWinnings = 0
        for (i in sorted.indices) {
            totalWinnings += sorted[i].bid * (i + 1)
        }
        return totalWinnings
    }

    fun solveDaySevenPartTwo(input: String): Int {
        val handBids = input.convertToHandBidsWithWildCard()
        val sorted = handBids.sortedWith { t, t2 ->
            val tValue = t.handType.value
            val t2Value = t2.handType.value
            if (tValue - t2Value == 0) {
                var i = 0
                var result = 0
                while (i < 5) {
                    result = compareCardWithWildCard(t.hand[i], t2.hand[i])
                    if (result == 0) {
                        i++
                    } else {
                        break
                    }
                }
                result
            } else {
                tValue - t2Value
            }
        }
        var totalWinnings = 0
        for (i in sorted.indices) {
            totalWinnings += sorted[i].bid * (i + 1)
        }
        return totalWinnings
    }

}