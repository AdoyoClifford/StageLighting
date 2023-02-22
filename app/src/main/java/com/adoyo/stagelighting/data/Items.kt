package com.adoyo.stagelighting.data

val allItems = listOf(
    Item(
        id = 1,
        name = "LED Moving Head Light",
        category = Category.LIGHTING,
        price = 899.99,
        image = "https://i.pinimg.com/564x/a9/27/02/a92702706c7a37890ea4eda753c0022f.jpg",
        description = "LED Moving Head Light is a type of lighting fixture used in stage performances, concerts, and events to create a dynamic visual effect. It consists of a head that contains multiple light-emitting diodes (LEDs) that can be individually controlled to produce various colors and patterns."
    ),
    Item(
        id = 2,
        name = "DMX Stage Lighting Controller",
        category = Category.LIGHTING,
        price = 349.99,
        image = "https://i.pinimg.com/564x/0a/c6/76/0ac676972eb40089be17e58d31bbed45.jpg",
        description = "A DMX Stage Lighting Controller is an electronic device that is used to control stage lighting fixtures, such as moving head lights, LED par cans, and fog machines. DMX stands for \"Digital Multiplex\", which is a standard protocol for controlling lighting equipment using digital signals over a data cable."
    ),
    Item(
        id = 3,
        name = "Fog Machine",
        category = Category.SPECIAL_EFFECTS,
        price = 129.99,
        image = "https://i.pinimg.com/564x/4b/32/dc/4b32dc488f6e10a0808998b19f8e28e2.jpg",
        description = "A fog machine is a device used to create a thick, white, and low-lying fog or mist, which is often used in stage productions, concerts, and haunted houses. It works by heating a special fluid or \"fog juice\" that is then vaporized and ejected into the air through a nozzle."
    ),
    Item(
        id = 4,
        name = "Snow Machine",
        category = Category.SPECIAL_EFFECTS,
        price = 199.99,
        image = "https://i.pinimg.com/564x/05/00/f6/0500f6aef4072bddfcbab8ab942f9932.jpg",
        description = "A snow machine is a device used to create a snow-like effect indoors or outdoors for stage productions, film shoots, or events. It works by blowing out a mixture of snow fluid and compressed air or fan, which creates a stream of tiny, lightweight snowflakes that float down and create the illusion of snow."
    ),
    Item(
        id = 5,
        name = "Wireless Microphone",
        category = Category.AUDIO,
        price = 89.99,
        image = "https://i.pinimg.com/564x/87/34/e3/8734e319b97dc9775b93678b0aeb9eff.jpg",
        description = "A wireless microphone is a device that allows the user to transmit audio signals from a microphone to a receiver without the need for a physical cable. It is commonly used in live performances, public speaking events, and video productions."
    ),
    Item(
        id = 6,
        name = "Powered Mixer",
        category = Category.AUDIO,
        price = 599.99,
        image = "https://i.pinimg.com/564x/7d/29/a8/7d29a8f3a0f7170d3a00fd1b9e976978.jpg",
        description = "A powered mixer is an audio mixing console that includes a built-in power amplifier, which eliminates the need for a separate external amplifier. It is commonly used in small to medium-sized sound reinforcement systems, such as in live performances, DJ setups, or home studios."
    ),
)


data class Item(
    val id: Int,
    val name: String,
    val category: Category,
    val price: Double,
    val image: String,
    val description: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            name,
            "${name.first()}}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

enum class Category(val label: String) {
    LIGHTING("Lighting"),
    AUDIO("Audio"),
    SPECIAL_EFFECTS("Special Effects")
}

sealed class Tab{
    object Home: Tab()
    object Add: Tab()
    object Chat: Tab()
    object Profile: Tab()
}

