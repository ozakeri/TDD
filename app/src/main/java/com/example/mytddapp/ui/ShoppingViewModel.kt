package com.example.mytddapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytddapp.data.local.ShoppingItem
import com.example.mytddapp.repository.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel @ViewModelInject constructor(
    private val repository: ShoppingRepository
) : ViewModel() {

    val getAllShoppingItems = repository.observeAllShoppingItems()

    val getTotalPrice = repository.observeTotalPrice()

    fun insertToDB(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insert(shoppingItem)
    }

    fun deleteFromDB(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.delete(shoppingItem)
    }


    fun insertShoppingItem(name : String,amountString : String,priceString : String){

        if(name.isEmpty() || amountString.isEmpty() || priceString.isEmpty()) {

        }
    }

}