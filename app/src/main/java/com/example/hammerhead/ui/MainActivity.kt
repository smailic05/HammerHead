package com.example.hammerhead.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.dellin.viewModel.MainViewModel
import com.example.hammerhead.Food
import com.example.hammerhead.R
import com.example.hammerhead.adapters.AppBarCategoriesAdapter
import com.example.hammerhead.adapters.AppBarBannerAdapter
import com.example.hammerhead.adapters.PizzaAdapter
import com.example.hammerhead.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import android.content.Context

import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.google.android.material.snackbar.Snackbar


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(false){
            viewModel.foodItem.observe(this,{
                viewModel.saveToDatabase()
                binding.recyclerPizza.adapter= PizzaAdapter(it)
            })
        }
        else {
            viewModel.getFromDatabase()
            viewModel.foodItem.observe(this,{
                binding.recyclerPizza.adapter= PizzaAdapter(it)
            })
        }
        viewModel.snackbar.observe(this,{
            Snackbar.make(binding.root,it,Snackbar.LENGTH_SHORT).show()
        })
        val listOfCategories= resources.getStringArray(R.array.categories).toList()
        binding.recycler.adapter= AppBarBannerAdapter()
        binding.recyclerCategory.adapter=AppBarCategoriesAdapter(listOfCategories)

    }
    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnected == true
    }
}