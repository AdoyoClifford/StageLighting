package com.adoyo.stagelighting.presentation.details_screen

import androidx.lifecycle.ViewModel
import com.adoyo.stagelighting.data.allDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailsViewModel: ViewModel() {
    private val _items = MutableStateFlow(allDetails)
    val items = _items.asStateFlow()
}