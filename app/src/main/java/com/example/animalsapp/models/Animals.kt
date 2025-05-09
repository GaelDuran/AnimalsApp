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
        name = "León",
        description = "El león (Panthera leo) es una especie de la familia Felidae y miembro del género Panthera. Se reconoce sobre todo por su cuerpo musculoso y de pecho profundo, su cabeza corta y redondeada, y su mechón peludo al final de la cola.",
        image = "https://cdn0.bioenciclopedia.com/es/posts/2/3/0/leon_32_600_square.jpg",
        imageGallery = listOf(
            "https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic_2788792_0.jpg",
            "https://www.ngenespanol.com/wp-content/uploads/2023/02/leon-como-es-el-rey-de-la-selva-y-cuales-son-sus-caracteristicas.jpg",
            "https://www.ngenespanol.com/wp-content/uploads/2023/08/dia-mundial-del-leon-curiosidades-sobre-el-rey-de-la-sabana.jpg",
            "https://concepto.de/wp-content/uploads/2019/05/leon-sabana-africa-e1559242836802.jpg"
        ),
        environmentId = "680c0510d10bbc79144edbb9",
        facts = listOf(
            "Las leonas crían a los cachorros y también son las principales cazadoras",
            "Los leones son los únicos felinos que viven en grupos. Una manada, puede tener hasta 30 leones, dependiendo de la cantidad de comida y agua disponible",
            "Sin su pelaje, los cuerpos del león y del tigre son tan parecidos que sólo los expertos pueden diferenciarlos"
        ),
        id = "680d2122d10bbc79144edbbf"
    ),




