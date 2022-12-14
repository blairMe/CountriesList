package com.blair.earthcountries.model.entities

import com.blair.earthcountries.model.entities.Flags

data class Countries(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val demonym: String,
    val flag: String,
    val flags: Flags,
    val independent: Boolean,
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int,
    val region: String,
    val subregion: String,
    val timezones: List<String>,
    val topLevelDomain: List<String>,
)