package com.blair.earthcountries

import retrofit2.Response

interface CountriesAPI {
    fun getCountries() : Response<List<Countries>>
}