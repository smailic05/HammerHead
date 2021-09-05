package com.example.hammerhead

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class EntityFood (

    @PrimaryKey(autoGenerate = true)
    var id:Long =0,

    val firstIngredient: String,
    
    val secondIngredient: String,

    val thirdIngredient: String,

    val fourthIngredient: String,

    val fifthIngredient: String,

    val mealImage: String,

    val title: String

    )