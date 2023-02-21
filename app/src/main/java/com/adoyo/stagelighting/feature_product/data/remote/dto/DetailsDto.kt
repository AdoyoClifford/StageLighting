package com.adoyo.stagelighting.feature_product.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DetailsDto(
    @SerializedName("r_id")
    val id: Int,
    @SerializedName("r_description")
    val description: String,
    @SerializedName("r_title")
    val title: String,
    val image: String
)
