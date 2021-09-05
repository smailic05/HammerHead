package com.example.hammerhead.room

import com.example.hammerhead.EntityFood
import com.example.hammerhead.Food
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RoomRepository @Inject constructor(private val foodDao: FoodDao) {

    fun insertIntoDatabase(arrayOfFood:Array<EntityFood>){
        foodDao.insertAll(*arrayOfFood)
    }
    fun deleteTable()
    {
        foodDao.nukeTable()
    }
    fun getAllFood():Array<EntityFood>
    {
       return foodDao.getAll()
    }
}