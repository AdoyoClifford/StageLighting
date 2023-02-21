package com.adoyo.stagelighting.feature_product.di

import com.adoyo.stagelighting.feature_product.data.remote.StageLightingApi
import com.adoyo.stagelighting.feature_product.data.repository.ItemsRepositoryImpl
import com.adoyo.stagelighting.feature_product.domain.repository.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ItemsModule {

    @Provides
    @Singleton
    fun provideRetrofitApi(): StageLightingApi {
        return Retrofit.Builder()
            .baseUrl("https://stagelighting-4d8cd-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StageLightingApi::class.java)
    }

    @Provides
    fun provideItemsRepository(api: StageLightingApi): ItemsRepository {
        return ItemsRepositoryImpl(api)
    }
}