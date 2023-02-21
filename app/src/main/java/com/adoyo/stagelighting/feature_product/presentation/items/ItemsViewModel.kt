package com.adoyo.stagelighting.feature_product.presentation.items

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.stagelighting.feature_product.domain.use_cases.GetItemsUseCase
import com.adoyo.stagelighting.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val getItemsUseCase: GetItemsUseCase) :
    ViewModel() {
    private val _state = mutableStateOf(ItemsListState())
    val state: State<ItemsListState> = _state

    init {
        getItems()
    }

    private fun getItems() {
        getItemsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ItemsListState(items = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        ItemsListState(error = result.message ?: "An Unexpected Error Occurred")
                }
                is Resource.Loading -> {
                    _state.value = ItemsListState(isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }
}