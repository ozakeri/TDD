package com.example.mytddapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_table")
data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
