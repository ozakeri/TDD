package com.example.mytddapp.repository

import ImageResponse
import androidx.lifecycle.LiveData
import com.example.mytddapp.data.local.ShoppingItem
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insert(shoppingItem: ShoppingItem)

    suspend fun delete(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(query: String): Response<ImageResponse>
}