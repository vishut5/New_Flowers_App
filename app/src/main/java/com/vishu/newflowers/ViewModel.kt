package com.vishu.newflowers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FlowerViewModel : ViewModel() {
    private val flowerApiService = Retrofit.Builder()
        .baseUrl("https://mocki.io/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FlowerApi::class.java)

    private val _flowers = MutableLiveData<List<Flower>>()
    val flowers: LiveData<List<Flower>>
        get() = _flowers

    fun fetchFlowers() {
        viewModelScope.launch {
            try {
                val flowersList = flowerApiService.getFlowers()
                _flowers.postValue(flowersList)
            } catch (e: Exception) {
                // Handle error
                Log.e("FlowerViewModel", "Error fetching flowers", e)
            }
        }
    }
}

private fun <T> MutableLiveData<T>.postValue(flowersList: Call<T>) {
    TODO("Not yet implemented")
}
