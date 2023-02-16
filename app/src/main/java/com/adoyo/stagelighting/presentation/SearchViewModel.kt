package com.adoyo.stagelighting.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

@OptIn(FlowPreview::class)
class MainViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val searching = _isSearching.asStateFlow()

    private val _persons = MutableStateFlow(allPersons)
    val persons = searchText.debounce(1000L).onEach { _isSearching.update { true } }
        .combine(_persons) { text, persons ->
            if (text.isBlank()) {
                persons
            } else {
                delay(2000)
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }.onEach { _isSearching.update { false } }.stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000), _persons.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

}

data class Person(
    val id: Int,
    val firstName: String,
    val lastName: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$firstName $lastName",
            "$firstName$lastName",
            "${firstName.first()} ${lastName.first()}"
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allPersons = listOf(
    Person(
        id = 1,
        firstName = "Philipp",
        lastName = "Lackner"
    ),
    Person(
        id = 2,
        firstName = "Beff",
        lastName = "Jezos"
    ),
    Person(
        id = 3,
        firstName = "Chris P.",
        lastName = "Bacon"
    ),
    Person(
        id = 4,
        firstName = "Jeve",
        lastName = "Stops"
    ),
)