package com.themobilecoder.adventofcode.day5

import com.themobilecoder.adventofcode.splitByNewLine

fun String.getSeedsToBePlanted(): List<UInt> {
    val lines = splitByNewLine()
    return lines.first {
        it.contains("seeds:")
    }.split(":")[1]
        .trim()
        .split(" ")
        .map {
            it.toUInt()
        }
}

fun String.getSeedPairsToBePlanted(): List<SeedPair> {
    val lines = splitByNewLine()
    return lines.first {
        it.contains("seeds:")
    }.split(":")[1]
        .trim()
        .split(" ")
        .map {
            it.toUInt()
        }
        .withIndex()
        .groupBy {
            it.index / 2
        }
        .map {
            SeedPair(
                start = it.value[0].value,
                range = it.value[1].value
            )
        }
}


fun String.getMapAsConversionObjectsFromConversionType(conversionType: ConversionType): List<ConversionObject> {
    val lines = splitByNewLine()
    val startIndexOfMap: Int = lines.indexOfFirst {
        it.contains(conversionType.value)
    }
    var i = startIndexOfMap + 1
    val conversionObjects = mutableListOf<ConversionObject>()
    while (i < lines.size && lines[i].isNotEmpty()) {
        val data = lines[i].split(" ").map { it.toUInt() }
        conversionObjects.add(
            ConversionObject(
                destination = data[0],
                source = data[1],
                range = data[2]
            )
        )
        ++i
    }
    return conversionObjects
}

fun String.getLocationValueFromSeed(seed: UInt): UInt {
    val inputString = this
    fun UInt.getConversionToType(conversionType: ConversionType): UInt {
        val conversionTypes =
            inputString.getMapAsConversionObjectsFromConversionType(conversionType)
        for (cType in conversionTypes) {
            val source = cType.source
            val destination = cType.destination
            val range = cType.range
            val upperRange = source + range
            val differenceFromSource = this - source
            if (this in source until upperRange) {
                //There is conversion
                return destination + differenceFromSource
            }
        }
        return this
    }
    return seed
        .getConversionToType(ConversionType.SEED_TO_SOIL)
        .getConversionToType(ConversionType.SOIL_TO_FERTILIZER)
        .getConversionToType(ConversionType.FERTILIZER_TO_WATER)
        .getConversionToType(ConversionType.WATER_TO_LIGHT)
        .getConversionToType(ConversionType.LIGHT_TO_TEMPERATURE)
        .getConversionToType(ConversionType.TEMPERATURE_TO_HUMIDITY)
        .getConversionToType(ConversionType.HUMIDITY_TO_LOCATION)

}

private fun UInt.getConversionToType(
    mapOfConversionObjectsByConversionType: Map<ConversionType, List<ConversionObject>>,
    conversionType: ConversionType
): UInt {
    val conversionObjects = mapOfConversionObjectsByConversionType[conversionType] ?: listOf()
    for (cType in conversionObjects) {
        val source = cType.source
        val destination = cType.destination
        val range = cType.range
        val upperRange = source + range
        val differenceFromSource = this - source
        if (this in source until upperRange) {
            //There is conversion
            return destination + differenceFromSource
        }
    }
    return this
}

fun getLocationValueFromSeedOptimised(
    mapOfConversionObjectsByConversionType: Map<ConversionType, List<ConversionObject>>,
    seed: UInt
): UInt {
    return seed
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.SEED_TO_SOIL)
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.SOIL_TO_FERTILIZER)
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.FERTILIZER_TO_WATER)
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.WATER_TO_LIGHT)
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.LIGHT_TO_TEMPERATURE)
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.TEMPERATURE_TO_HUMIDITY)
        .getConversionToType(mapOfConversionObjectsByConversionType, ConversionType.HUMIDITY_TO_LOCATION)

}