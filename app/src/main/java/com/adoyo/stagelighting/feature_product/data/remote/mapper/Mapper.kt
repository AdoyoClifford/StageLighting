package com.adoyo.stagelighting.feature_product.data.remote.mapper

import com.adoyo.stagelighting.feature_product.data.remote.dto.DetailsDto
import com.adoyo.stagelighting.feature_product.data.remote.dto.ItemsDto
import com.adoyo.stagelighting.feature_product.domain.model.Details
import com.adoyo.stagelighting.feature_product.domain.model.Items

fun ItemsDto.toItem(): Items {
    return Items(
        id = id,
        title = title,
        image = image
    )
}

fun DetailsDto.todDetails(): Details {
    return Details(
        id = id,
        title = title,
        description = description,
        image = image
    )

}