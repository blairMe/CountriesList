package com.blair.earthcountries

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    val api : CountriesAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://restcountries.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }
}