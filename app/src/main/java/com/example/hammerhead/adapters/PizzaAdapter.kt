package com.example.hammerhead.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hammerhead.Food
import com.example.hammerhead.databinding.PizzaViewBinding
import android.content.res.Resources




class PizzaAdapter(var food: Food) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: PizzaViewBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){

            val position=bindingAdapterPosition
            val meal =food.meals[position]
            binding.imagePizza.load(meal.mealImage)
            binding.title.text=meal.title
            val placeholder = "${meal.firstIngredient}, ${meal.secondIngredient}, " +
                    "${meal.thirdIngredient}, ${meal.fourthIngredient}, ${meal.fifthIngredient}"
            binding.description.text=placeholder
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PizzaViewBinding.inflate(layoutInflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = food.meals.size

}
