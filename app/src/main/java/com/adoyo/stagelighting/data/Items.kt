package com.adoyo.stagelighting.data

val items = listOf(
    Item(
        id = 1,
        name = "LED Moving Head Light",
        category = Category.LIGHTING,
        price = 899.99,
        image = "https://i.pinimg.com/564x/a9/27/02/a92702706c7a37890ea4eda753c0022f.jpg"
    ),
    Item(
        id = 2,
        name = "DMX Stage Lighting Controller",
        category = Category.LIGHTING,
        price = 349.99,
        image = "https://i.pinimg.com/564x/0a/c6/76/0ac676972eb40089be17e58d31bbed45.jpg"
    ),
    Item(
        id = 3,
        name = "Fog Machine",
        category = Category.SPECIAL_EFFECTS,
        price = 129.99,
        image = ""
    ),
    Item(
        id = 4,
        name = "Snow Machine",
        category = Category.SPECIAL_EFFECTS,
        price = 199.99,
        image = "https://i.pinimg.com/564x/05/00/f6/0500f6aef4072bddfcbab8ab942f9932.jpg"
    ),
    Item(
        id = 5,
        name = "Wireless Microphone",
        category = Category.AUDIO,
        price = 89.99,
        image = "https://i.pinimg.com/564x/87/34/e3/8734e319b97dc9775b93678b0aeb9eff.jpg"
    ),
    Item(
        id = 6,
        name = "Powered Mixer",
        category = Category.AUDIO,
        price = 599.99,
        image = "https://i.pinimg.com/564x/7d/29/a8/7d29a8f3a0f7170d3a00fd1b9e976978.jpg"
    ),
)


data class Item(
    val id: Int,
    val name: String,
    val category: Category,
    val price: Double,
    val image: String
)

enum class Category(val label: String) {
    LIGHTING("Lighting"),
    AUDIO("Audio"),
    SPECIAL_EFFECTS("Special Effects")
}

