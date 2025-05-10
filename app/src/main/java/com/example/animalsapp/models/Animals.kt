package com.example.animalsapp.models

import com.google.gson.annotations.SerializedName

data class Animals(
    val description: String,
    val environmentId: String,
    val facts: List<String>,
    @SerializedName("_id") val id: String,
    val image: String,
    val imageGallery: List<String>,
    val name: String
)

data class Environment(
    val id: String,
    val name: String,
    val image: String,
    val description: String // Añadido para Pantalla 4
)

val mockAnimalList = listOf(
    Animals(
        name = "Nutria Asian Small-Clawed",
        description = "La nutria asian small clawed otter (Amblonyx cinereus) es una especie de la familia Mustelidae y es la más pequeña de todas las especies de nutrias. Se distingue por sus garras cortas y su capacidad para utilizarlas hábilmente.",
        image = "https://i.redd.it/04rwloagnx551.jpg",
        imageGallery = listOf(
            "https://i.ytimg.com/vi/VcF8U1FAjoc/maxresdefault.jpg",
            "https://i.ytimg.com/vi/BgkVsTNTebM/sddefault.jpg"
        ),
        environmentId = "680c0510d10bbc79144edbb8",
        facts = listOf(
            "Las nutrias asian small clawed otter son conocidas por su comportamiento social y a menudo forman grupos familiares.",
            "Utilizan sus garras cortas para capturar presas y manipular objetos en su entorno acuático.",
            "Son muy ágiles en el agua y pueden nadar rápidamente para cazar peces y otros animales acuáticos."
        ),
        id = "680d2122d10bbc79144edbbe"
    ),
    Animals(
        name = "Camello",
        description = "El camello es un mamífero adaptado a los desiertos, conocido por su capacidad de almacenar agua.",
        image = "https://example.com/camel.jpg",
        imageGallery = listOf(
            "https://example.com/camel1.jpg",
            "https://example.com/camel2.jpg"
        ),
        environmentId = "680c0510d10bbc79144edbbd",
        facts = listOf(
            "Los camellos pueden sobrevivir semanas sin agua.",
            "Sus jorobas almacenan grasa, no agua.",
            "Tienen párpados especiales para protegerse de la arena."
        ),
        id = "680d2122d10bbc79144edbc4"
    ),
    Animals(
        name = "Oso Polar",
        description = "El oso polar es un gran depredador del Ártico, adaptado a climas fríos y hielo marino.",
        image = "https://example.com/polarbear.jpg",
        imageGallery = listOf(
            "https://example.com/polarbear1.jpg",
            "https://example.com/polarbear2.jpg"
        ),
        environmentId = "680c0510d10bbc79144edbbc",
        facts = listOf(
            "Los osos polares son excelentes nadadores.",
            "Su pelaje es translúcido y ayuda a camuflarse en la nieve.",
            "Dependen del hielo marino para cazar focas."
        ),
        id = "680d2122d10bbc79144edbc3"
    )
)

val mockEnvironmentList = listOf(
    Environment(
        id = "680c0510d10bbc79144edbb8",
        name = "Océano",
        image = "https://example.com/ocean.jpg",
        description = "Un océano aquático con un costa rocosa."
    ),
    Environment(
        id = "680c0510d10bbc79144edbb9",
        name = "Bosque",
        image = "https://example.com/forest.jpg",
        description = "Un bosque con árboles altos y frondosos."
    ),
    Environment(
        id = "680c0510d10bbc79144edbbc",
        name = "Ártico",
        image = "https://example.com/arctic.jpg",
        description = "Una región fría con hielo y nieve."
    ),
    Environment(
        id = "680c0510d10bbc79144edbbd",
        name = "Desierto",
        image = "https://example.com/desert.jpg",
        description = "Un desierto árido con dunas de arena."
    )
)