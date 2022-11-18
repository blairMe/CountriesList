package com.blair.earthcountries.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : CountriesAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }
}