package com.themobilecoder.adventofcode.day5

enum class ConversionType(val value: String) {
    SEED_TO_SOIL("seed-to-soil"),
    SOIL_TO_FERTILIZER("soil-to-fertilizer"),
    FERTILIZER_TO_WATER("fertilizer-to-water"),
    WATER_TO_LIGHT("water-to-light"),
    LIGHT_TO_TEMPERATURE("light-to-temperature"),
    TEMPERATURE_TO_HUMIDITY("temperature-to-humidity"),
    HUMIDITY_TO_LOCATION("humidity-to-location")
}