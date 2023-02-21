package com.adoyo.stagelighting.feature_product.presentation.details

import com.adoyo.stagelighting.feature_product.domain.model.Details

data class DetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val details: Details? = null
)
