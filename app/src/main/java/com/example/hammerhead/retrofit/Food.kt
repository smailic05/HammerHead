package com.example.hammerhead

import com.google.gson.annotations.SerializedName

data class Food(

	@field:SerializedName("meals")
	val meals:List<RetrofitMealsItem>
)

data class RetrofitMealsItem(

	@field:SerializedName("strIngredient1")
	val firstIngredient: String,

	@field:SerializedName("strIngredient3")
	val thirdIngredient: String,

	@field:SerializedName("strIngredient2")
	val secondIngredient: String,

	@field:SerializedName("strIngredient5")
	val fifthIngredient: String,

	@field:SerializedName("strIngredient4")
	val fourthIngredient: String,

	@field:SerializedName("strMealThumb")
	val mealImage: String,

	@field:SerializedName("strMeal")
	val title: String,

)
