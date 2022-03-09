package com.example.mytddapp.repository

import ImageResponse
import Resource
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.mytddapp.data.local.ShoppingDao
import com.example.mytddapp.data.local.ShoppingItem
import com.example.mytddapp.data.remote.ShoppingApi
import retrofit2.Response

class ShoppingRepositoryImpl(
    private val shoppingDao: ShoppingDao,
    private val shoppingApi: ShoppingApi
) : ShoppingRepository {
    override suspend fun insert(shoppingItem: ShoppingItem) {
        shoppingDao.insert(shoppingItem)
    }

    override suspend fun delete(shoppingItem: ShoppingItem) {
        shoppingDao.delete(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = shoppingApi.searchForImage(imageQuery)
            if(response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            } else {
                Resource.error("An unknown error occured", null)
            }
        } catch(e: Exception) {
            Log.e("EXCEPTION", "EXCEPTION:", e)
            Resource.error("Couldn't reach the server. Check your internet connection", null)
        }
    }
}