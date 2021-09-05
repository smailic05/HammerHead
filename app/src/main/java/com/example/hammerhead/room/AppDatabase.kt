package com.example.hammerhead.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hammerhead.EntityFood

@Database(entities = arrayOf(EntityFood::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}