package com.blair.earthcountries.model.network

import com.blair.earthcountries.model.entities.Countries
import retrofit2.Response
import retrofit2.http.GET

interface CountriesAPI {
    @GET("/v2/all")
    suspend fun getCountries() : Response<List<Countries>>
}