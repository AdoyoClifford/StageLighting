package com.adoyo.stagelighting.feature_product.presentation.items

import com.adoyo.stagelighting.feature_product.domain.model.Details
import com.adoyo.stagelighting.feature_product.domain.model.Items

data class ItemsListState(
    val isLoading: Boolean = false,
    val items: List<Items> = emptyList(),
    val error: String = ""
)
