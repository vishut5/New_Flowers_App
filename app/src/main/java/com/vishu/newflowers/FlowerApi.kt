package com.vishu.newflowers

import retrofit2.Call
import retrofit2.http.GET

interface FlowerApi {
    @GET("/86dc0d4f-652d-4fc3-80d3-573d02697bb8")
    fun getFlowers(): Call<List<Flower>>
}
