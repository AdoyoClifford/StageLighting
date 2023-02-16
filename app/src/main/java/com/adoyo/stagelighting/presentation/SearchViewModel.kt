package com.adoyo.stagelighting.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.stagelighting.presentation.model.Products
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class MainViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _products = MutableStateFlow(allPersons)
    val products = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_products) { text, persons ->
            if (text.isBlank()) {
                persons
            } else {
                delay(2000L)
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _products.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}


private val allPersons = listOf(
    Products(image = "https://i.pinimg.com/564x/2c/46/c2/2c46c2010b73e411005309acf813ece9.jpg",
    name = "Laser Projector", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200),
    Products(
        image = "https://i.pinimg.com/564x/d9/bc/5e/d9bc5e7a2d63210998b15b3e8463fb19.jpg",
        name = "Stage Floor Lamp", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(
        image = "https://i.pinimg.com/564x/17/b6/87/17b687efc87ab7e42d33b14c66cfd570.jpg",
        name = "Search Light", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(
        image = "https://i.pinimg.com/564x/2d/fe/0e/2dfe0efc33274093fce9c82af0d2c446.jpg",
        name = "Waygor", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(image = "https://i.pinimg.com/564x/2c/46/c2/2c46c2010b73e411005309acf813ece9.jpg",
        name = "Laser Projector", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200),
    Products(
        image = "https://i.pinimg.com/564x/d9/bc/5e/d9bc5e7a2d63210998b15b3e8463fb19.jpg",
        name = "Stage Floor Lamp", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(
        image = "https://i.pinimg.com/564x/17/b6/87/17b687efc87ab7e42d33b14c66cfd570.jpg",
        name = "Search Light", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(
        image = "https://i.pinimg.com/564x/2d/fe/0e/2dfe0efc33274093fce9c82af0d2c446.jpg",
        name = "Waygor", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(image = "https://i.pinimg.com/564x/2c/46/c2/2c46c2010b73e411005309acf813ece9.jpg",
        name = "Laser Projector", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200),
    Products(
        image = "https://i.pinimg.com/564x/d9/bc/5e/d9bc5e7a2d63210998b15b3e8463fb19.jpg",
        name = "Stage Floor Lamp", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(
        image = "https://i.pinimg.com/564x/17/b6/87/17b687efc87ab7e42d33b14c66cfd570.jpg",
        name = "Search Light", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
    Products(
        image = "https://i.pinimg.com/564x/2d/fe/0e/2dfe0efc33274093fce9c82af0d2c446.jpg",
        name = "Waygor", pricePerHour = 50, pricePerDay = 100, pricePerWeek = 200
    ),
)