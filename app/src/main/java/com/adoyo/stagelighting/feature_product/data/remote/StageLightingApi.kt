package com.adoyo.stagelighting.feature_product.data.remote

import com.adoyo.stagelighting.feature_product.data.remote.dto.DetailsDto
import com.adoyo.stagelighting.feature_product.data.remote.dto.ItemsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface StageLightingApi {
    @GET("stage.json")
    suspend fun getItems(): List<ItemsDto>

    @GET("stage.json?orderBy=\"r_id\"")
    suspend fun getItem(@Query("equalTo")id: Int): DetailsDto
}