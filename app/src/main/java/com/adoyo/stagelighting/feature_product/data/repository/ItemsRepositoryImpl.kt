package com.adoyo.stagelighting.feature_product.data.repository

import com.adoyo.stagelighting.feature_product.data.remote.StageLightingApi
import com.adoyo.stagelighting.feature_product.data.remote.dto.DetailsDto
import com.adoyo.stagelighting.feature_product.data.remote.dto.ItemsDto
import com.adoyo.stagelighting.feature_product.domain.repository.ItemsRepository
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(private val api: StageLightingApi): ItemsRepository {
    override suspend fun getCoins(): List<ItemsDto> {
        return api.getItems()
    }

    override suspend fun getCoinById(coinId: Int): DetailsDto {
        return api.getItem(coinId)
    }
}