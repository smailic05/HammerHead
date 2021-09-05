package com.example.hammerhead.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hammerhead.EntityFood

@Dao
interface FoodDao {

    @Query("SELECT * FROM food ORDER BY id DESC")
    fun getAll(): Array<EntityFood>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg logs: EntityFood)

    @Query("DELETE FROM food")
    fun nukeTable()
}