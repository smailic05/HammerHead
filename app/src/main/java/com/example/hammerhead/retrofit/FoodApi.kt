package com.example.hammerhead.retrofit

import com.example.hammerhead.Food
import retrofit2.http.GET

public interface FoodApi {
    @GET("/api/json/v1/1/search.php?f=a")
    suspend fun getFood(): Food
}