package com.adoyo.stagelighting.presentation.model

data class Products(
    val image: String,
    val name: String,
    val pricePerHour: Int,
    val pricePerDay: Int,
    val pricePerWeek: Int
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name, "${name.first()}",
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
