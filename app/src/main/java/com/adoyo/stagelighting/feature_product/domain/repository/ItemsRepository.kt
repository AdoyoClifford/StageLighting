package com.adoyo.stagelighting.feature_product.domain.repository

import com.adoyo.stagelighting.feature_product.data.remote.dto.DetailsDto
import com.adoyo.stagelighting.feature_product.data.remote.dto.ItemsDto

interface ItemsRepository {
    suspend fun getCoins(): List<ItemsDto>
    suspend fun getCoinById(coinId: Int): DetailsDto
}