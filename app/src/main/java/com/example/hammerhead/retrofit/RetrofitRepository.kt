package com.example.hammerhead.retrofit

import com.example.hammerhead.Food

class RetrofitRepository {

    private val foodApi=RetrofitBuilder.apiService

    suspend fun getFood(): Food {
        return foodApi.getFood()
    }
}