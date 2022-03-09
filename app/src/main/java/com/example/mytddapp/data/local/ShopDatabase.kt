package com.example.mytddapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun shoppingDao(): ShoppingDao
}