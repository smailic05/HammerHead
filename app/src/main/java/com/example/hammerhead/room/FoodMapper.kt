package com.example.hammerhead.room

import com.example.hammerhead.EntityFood
import com.example.hammerhead.Food
import com.example.hammerhead.RetrofitMealsItem

class FoodMapper {
    private fun toFoodEntity(meals: RetrofitMealsItem): EntityFood {
        return EntityFood(
            title = meals.title,
            firstIngredient = meals.firstIngredient,
            secondIngredient = meals.secondIngredient,
            thirdIngredient = meals.thirdIngredient,
            fourthIngredient=meals.fourthIngredient,
            fifthIngredient=meals.fifthIngredient,
            mealImage = meals.mealImage
        )
    }
    fun toFoodEntityList(food: Food):List<EntityFood>{
        val listOfFood= mutableListOf<EntityFood>()
        for (item in food.meals)
            listOfFood.add(toFoodEntity(item))
        return listOfFood
    }
    private fun toMealsItem(meals: EntityFood): RetrofitMealsItem {
        return RetrofitMealsItem(
            title = meals.title,
            firstIngredient = meals.firstIngredient,
            secondIngredient = meals.secondIngredient,
            thirdIngredient = meals.thirdIngredient,
            fourthIngredient=meals.fourthIngredient,
            fifthIngredient=meals.fifthIngredient,
            mealImage = meals.mealImage
        )
    }
    fun toFood(food: Array<EntityFood>):Food{
        val retrofitMealsItem= mutableListOf<RetrofitMealsItem>()
        for (item in food)
            retrofitMealsItem.add(toMealsItem(item))
        return Food(retrofitMealsItem)
    }
}