package com.adoyo.stagelighting.presentation.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.stagelighting.data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow(mutableListOf<CartItem>())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    private val _cartCountItems = MutableStateFlow(0)
    val cartCountItems: StateFlow<Int> = _cartCountItems

    init {
        viewModelScope.launch {
            _cartItems.collect {
                _cartCountItems.value = it.size
                Log.d("CartViewModel", "Cart count items: ${_cartCountItems.value}")
            }
        }
    }

    fun increment() {
        _cartCountItems.value++
    }

    private fun resetCount() {
        _cartCountItems.value = 0
    }
}