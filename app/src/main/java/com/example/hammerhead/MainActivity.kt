package com.example.hammerhead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.hammerhead.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val categoriesAdapter=AppBarCategoriesAdapter()
    private lateinit var binding: ActivityMainBinding
    private val listOfCategories= listOf("Пицца","Комбо","Десерты","Напитки","Напитки","Напитки","Напитки","Напитки","Напитки","Напитки")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter=AppBarImageAdapter()
        binding.recyclerCategory.adapter=categoriesAdapter
        categoriesAdapter.submitList(listOfCategories)
    }

}