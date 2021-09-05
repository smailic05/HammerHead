package com.example.dellin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammerhead.Food
import com.example.hammerhead.retrofit.RetrofitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    private val repositoryRetrofit: RetrofitRepository = RetrofitRepository()

    private var _foodItem= MutableLiveData<Food>()
    val foodItem
        get()=_foodItem
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _foodItem.postValue(repositoryRetrofit.getFood())
        }
    }

}