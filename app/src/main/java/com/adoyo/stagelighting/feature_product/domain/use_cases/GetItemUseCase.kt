package com.adoyo.stagelighting.feature_product.domain.use_cases

import com.adoyo.stagelighting.feature_product.data.remote.mapper.todDetails
import com.adoyo.stagelighting.feature_product.domain.model.Details
import com.adoyo.stagelighting.feature_product.domain.repository.ItemsRepository
import com.adoyo.stagelighting.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetItemUseCase @Inject constructor(private val repository: ItemsRepository) {
    operator fun invoke(coinId: Int): Flow<Resource<Details>> = flow {
        try {
            emit(Resource.Loading())
            val item = repository.getCoinById(coinId).todDetails()
            emit(Resource.Success<Details>(item))
        } catch (e: HttpException) {
            emit(Resource.Error<Details>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<Details>("Couldn't reach server. Check your internet connection."))
        }
    }
}