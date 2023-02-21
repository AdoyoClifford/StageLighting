package com.adoyo.stagelighting.feature_product.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ItemsDto(
    @SerializedName("r_id")
    val id: Int,
    @SerializedName("r_title")
    val title: String,
    val image: String
)
