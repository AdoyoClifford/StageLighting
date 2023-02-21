package com.adoyo.stagelighting.feature_product.domain.use_cases

import com.adoyo.stagelighting.feature_product.data.remote.mapper.toItem
import com.adoyo.stagelighting.feature_product.domain.model.Items
import com.adoyo.stagelighting.feature_product.domain.repository.ItemsRepository
import com.adoyo.stagelighting.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(private val repository: ItemsRepository) {
    operator fun invoke(): Flow<Resource<List<Items>>> = flow {
        try {
            emit(Resource.Loading())
            val items = repository.getCoins()
            emit(Resource.Success(items.map { it.toItem() }))

        } catch (e: HttpException) {
          emit(Resource.Error(e.localizedMessage ?: "An Unknown Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
        }
    }
}