package com.themobilecoder.adventofcode.day5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentLinkedQueue

class DayFive {

    private val coroutineContext = CoroutineScope(IO)

    fun solveDayFivePartOne(input: String) : UInt {
        val seeds = input.getSeedsToBePlanted()
        val locations = mutableListOf<UInt>()
        seeds.forEach { seed ->
            val location = input.getLocationValueFromSeed(seed)
            locations.add(location)
        }
        return locations.min()
    }

    suspend fun solveDayFivePartTwo(input: String) : UInt {
        val seedPairs = input.getSeedPairsToBePlanted()
        var minLocation = 999999999u
        val mapOfConversionObjectsByConversionType = mapOf(
            ConversionType.SEED_TO_SOIL to input.getMapAsConversionObjectsFromConversionType(ConversionType.SEED_TO_SOIL),
            ConversionType.SOIL_TO_FERTILIZER to input.getMapAsConversionObjectsFromConversionType(ConversionType.SOIL_TO_FERTILIZER),
            ConversionType.FERTILIZER_TO_WATER to input.getMapAsConversionObjectsFromConversionType(ConversionType.FERTILIZER_TO_WATER),
            ConversionType.WATER_TO_LIGHT to input.getMapAsConversionObjectsFromConversionType(ConversionType.WATER_TO_LIGHT),
            ConversionType.LIGHT_TO_TEMPERATURE to input.getMapAsConversionObjectsFromConversionType(ConversionType.LIGHT_TO_TEMPERATURE),
            ConversionType.TEMPERATURE_TO_HUMIDITY to input.getMapAsConversionObjectsFromConversionType(ConversionType.TEMPERATURE_TO_HUMIDITY),
            ConversionType.HUMIDITY_TO_LOCATION to input.getMapAsConversionObjectsFromConversionType(ConversionType.HUMIDITY_TO_LOCATION),
        )
        val jobs = ConcurrentLinkedQueue<Job>()
        seedPairs.forEach {
             val job = coroutineContext.launch {
                val start = it.start
                val range = it.range
                val upperRange = start + range
                for (i in start until upperRange) {
                    val location = getLocationValueFromSeedOptimised(mapOfConversionObjectsByConversionType, i)
                    if (location <  minLocation) {
                        minLocation = location
                    }
                }
            }
            jobs.add(job)
        }

        jobs.joinAll()

        return minLocation
    }
}