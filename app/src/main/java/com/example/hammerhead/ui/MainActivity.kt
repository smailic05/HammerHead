package com.example.hammerhead.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import com.example.dellin.viewModel.MainViewModel
import com.example.hammerhead.R
import com.example.hammerhead.adapters.AppBarCategoriesAdapter
import com.example.hammerhead.adapters.AppBarBannerAdapter
import com.example.hammerhead.adapters.PizzaAdapter
import com.example.hammerhead.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.foodItem.observe(this,{
            binding.recyclerPizza.adapter= PizzaAdapter(it)
        })

        val listOfCategories= resources.getStringArray(R.array.categories).toList()
        binding.recycler.adapter= AppBarBannerAdapter()
        binding.recyclerCategory.adapter=AppBarCategoriesAdapter(listOfCategories)
    }
}