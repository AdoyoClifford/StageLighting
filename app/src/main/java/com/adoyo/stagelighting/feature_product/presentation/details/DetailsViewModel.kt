package com.adoyo.stagelighting.feature_product.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.stagelighting.feature_product.domain.use_cases.GetItemUseCase
import com.adoyo.stagelighting.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getItemUseCase: GetItemUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(DetailsState())
    val state: State<DetailsState> = _state

    private fun getDetails(itemId: Int) {
        getItemUseCase(itemId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DetailsState(details = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        DetailsState(error = result.message ?: "An Unexpected Error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = DetailsState(isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }
}