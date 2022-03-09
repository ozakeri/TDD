package com.example.mytddapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomMasterTable.TABLE_NAME
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mytddapp.R
import com.example.mytddapp.data.local.ShopDatabase
import com.example.mytddapp.data.remote.ShoppingApi
import com.example.mytddapp.other.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ShoppingAppModule {

    @Provides
    @Singleton
    fun provideShoppingItemDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ShopDatabase::class.java, TABLE_NAME).build()

    @Provides
    @Singleton
    fun provideShoppingDao(shopDatabase: ShopDatabase) = shopDatabase.shoppingDao()

    @Provides
    @Singleton
    fun providePixabayApi(): ShoppingApi = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ShoppingApi::class.java)

    @Provides
    @Singleton
    fun provideGlideInstance(@ApplicationContext context: Context) =
        Glide.with(context).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
        )
}