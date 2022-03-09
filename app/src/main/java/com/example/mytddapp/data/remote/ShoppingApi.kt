package com.example.mytddapp.data.remote

import ImageResponse
import com.example.mytddapp.other.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingApi {

    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchKey: String,
        @Query("key") apiKey: String = API_KEY
    ): Response<ImageResponse>
}