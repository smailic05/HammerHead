package com.example.dellin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammerhead.Food
import com.example.hammerhead.retrofit.RetrofitRepository
import com.example.hammerhead.room.FoodMapper
import com.example.hammerhead.room.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val roomRepository: RoomRepository): ViewModel() {
    private val repositoryRetrofit: RetrofitRepository = RetrofitRepository()
    private val foodMapper=FoodMapper()
    private var _foodItem= MutableLiveData<Food>()
    val foodItem
        get()=_foodItem
    private var _snackbar= MutableLiveData<String>()
    val snackbar
        get()=_snackbar
    init {
        viewModelScope.launch(Dispatchers.IO) {
            try{
            _foodItem.postValue(repositoryRetrofit.getFood())
            }
            catch (exception:Exception){
                snackbar.postValue("ERROR")
            }
        }
    }
    fun saveToDatabase() = viewModelScope.launch(Dispatchers.IO){
        val temp =foodMapper.toFoodEntityList(foodItem.value!!).toTypedArray()
        roomRepository.insertIntoDatabase(temp)
    }
    fun getFromDatabase() = viewModelScope.launch(Dispatchers.IO){
        _foodItem.postValue(foodMapper.toFood(roomRepository.getAllFood()))
    }

}