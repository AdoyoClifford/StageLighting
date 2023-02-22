package com.adoyo.stagelighting.presentation.cart

import androidx.lifecycle.ViewModel
import com.adoyo.stagelighting.data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow



class CartViewModel : ViewModel() {

    private val _items = MutableStateFlow(emptyList<CartStateItem>())
    val items: StateFlow<List<CartStateItem>> = _items

    val total: Double
        get() = _items.value.sumOf { it.quantity * it.item.price }

    fun addItem(item: Item,quantity: Int) {
        val existingItem = _items.value.find { it.item == item }
        if (existingItem != null) {
            existingItem.quantity++
            _items.value = _items.value.toList()
        } else {
            _items.value = _items.value + CartStateItem(item, 1)
        }
    }

    fun removeItem(cartItem: CartStateItem) {
        if (cartItem.quantity > 1) {
            cartItem.quantity--
            _items.value = _items.value.toList()
        } else {
            _items.value = _items.value - cartItem
        }
    }

    fun clear() {
        _items.value = emptyList()
    }
}