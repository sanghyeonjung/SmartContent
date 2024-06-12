package com.example.a3gradesmartcontent

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("/{day}")
    fun getWeather(@Path("day") day : Int): Call<JobRes>
}