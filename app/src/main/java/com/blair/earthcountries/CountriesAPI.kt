package com.blair.earthcountries

import retrofit2.Response
import retrofit2.http.GET

interface CountriesAPI {
    @GET("/v2/all")
    suspend fun getCountries() : Response<List<Countries>>
}