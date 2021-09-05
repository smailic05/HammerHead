package com.example.hammerhead.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//Builder для создания экземпляра класса Retrofit
object RetrofitBuilder {
    private const val BASE_URL = "https://themealdb.com"

    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiService: FoodApi = getRetrofit().create(FoodApi::class.java)
}