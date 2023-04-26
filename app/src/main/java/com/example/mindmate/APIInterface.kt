package com.example.mindmate

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIInterface {
    @POST("response")
    fun getData(@Body jsonObject: JsonObject): Call<List<BotResponseItem>>

    @GET("rt")
    fun gtt(): Call<List<BotResponseItem>>
}