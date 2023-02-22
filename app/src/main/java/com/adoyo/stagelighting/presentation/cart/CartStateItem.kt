package com.adoyo.stagelighting.presentation.cart

import com.adoyo.stagelighting.data.Item

data class CartItem(
    val id: Int,
    val name: String,
    val price: Double,
    var quantity: Int = 1
)