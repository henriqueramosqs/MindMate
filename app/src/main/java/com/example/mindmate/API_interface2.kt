package com.example.mindmate

import retrofit2.Call
import retrofit2.http.GET

interface API_interface2 {
    @GET("posts")
    fun get_test():Call<List<testingItem>>
}