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
    val image: String
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
    Animals(
        name = "Elefante",
        description = "Los elefantes son mamíferos grandes de la familia Elephantidae y el orden Proboscidea. Actualmente se reconocen tres especies: el elefante africano de sabana, el elefante africano de bosque y el elefante asiático.",
        image = "https://files.worldwildlife.org/wwfcmsprod/images/elephants_at_water_hole_WW2122503_Anup_Shah/story_full_width/7ozyekgso2_Medium_WW2122503.jpg",
        imageGallery = listOf(
            "https://www.nationalgeographic.com.es/medio/2020/03/04/elefante-en-el-parque-nacional-de-amboseli-con-el-kilimanjaro-al-fondo_4308fa58_800x800.jpg",
            "https://www.nationalgeographic.com.es/medio/2023/04/28/agarran-los-objetos-envolviendolos-con-la-trompa_9626e53e_358525301_230428113115_800x800.jpg",
            "https://d7lju56vlbdri.cloudfront.net/var/ezwebin_site/storage/images/_aliases/seo/noticias/efectos-a-largo-plazo-de-la-caza-furtiva-los-elefantes-sin-madre-sobreviven-menos/9204524-1-esl-MX/Efectos-a-largo-plazo-de-la-caza-furtiva-los-elefantes-sin-madre-sobreviven-menos.jpg"
        ),
        environmentId = "680c0510d10bbc79144edbb9",
        facts = listOf(
            "Los elefantes son capaces de experimentar una amplia gama de emociones, incluyendo alegría, enojo, dolor y juego.",
            "La trompa de un elefante tiene más de 40,000 músculos y tendones.",
            "Los elefantes tienen un fuerte sentido de la familia y se sabe que lamentan a sus muertos."
        ),
        id = "680d2122d10bbc79144edbc0"
    ),
    Animals(
        name = "Delfín",
        description = "Los delfines son un grupo ampliamente distribuido de mamíferos marinos conocidos por su inteligencia, comportamiento social y exhibiciones acrobáticas.",
        image = "https://images.dolphinaris.com/images/2015/03/5-curiosidades-sobre-los-delfines-Dolphinaris.jpg",
        imageGallery = listOf(
            "https://www.delphinusworld.com/hubfs/Delph_Portada7_DatosDeLosDelfines.jpg",
            "https://aquaworld.com.mx/uploads/0000/1/2023/06/15/15-hechos-curiosos-sobre-delfines-1100x619.jpg",
            "https://imagenes.muyinteresante.es/files/composte_image/uploads/2023/05/12/645df57d041b4.jpeg"
        ),
        environmentId = "680c0510d10bbc79144edbba",
        facts = listOf(
            "Los delfines utilizan un sistema complejo de clics y silbidos para comunicarse entre sí.",
            "Algunas especies de delfines pueden nadar a velocidades de hasta 37 mph (60 km/h).",
            "Los delfines han sido conocidos por salvar a los humanos de tiburones y guiar a nadadores perdidos de regreso a la orilla."
        ),
        id = "680d2122d10bbc79144edbc1"
    ),
    Animals(
        name = "Tigre",
        description = "El tigre (Panthera tigris) es la especie de felino más grande y miembro del género Panthera. Son animales solitarios y se sabe que son capaces de nadar.",
        image = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Tigress_at_Jim_Corbett_National_Park.jpg/250px-Tigress_at_Jim_Corbett_National_Park.jpg",
        imageGallery = listOf(
            "https://s1.eestatic.com/2023/07/29/ciencia/782681856_235038553_1706x960.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Sumatratiger-004.jpg/220px-Sumatratiger-004.jpg",
            "https://files.worldwildlife.org/wwfcmsprod/images/Tiger_resting_Bandhavgarh_National_Park_India/hero_small/6aofsvaglm_Medium_WW226365.jpg"
        ),
        environmentId = "680c0510d10bbc79144edbbb",
        facts = listOf(
            "Los tigres son excelentes nadadores y a menudo se refrescan descansando en estanques o arroyos.",
            "Un grupo de tigres se conoce como una 'racha' o un 'emboscada'.",
            "Los tigres tienen manchas blancas distintivas en la parte posterior de sus orejas llamadas 'manchas oculares'."
        ),
        id = "680d2122d10bbc79144edbc2"
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
    )
)

val mockEnvironmentList = listOf(
    Environment(
        id = "680c0510d10bbc79144edbb8",
        name = "Océano",
        image = "https://example.com/ocean.jpg"
    ),
    Environment(
        id = "680c0510d10bbc79144edbb9",
        name = "Bosque",
        image = "https://example.com/forest.jpg"
    ),
    Environment(
        id = "680c0510d10bbc79144edbba",
        name = "Océano",
        image = "https://example.com/ocean.jpg"
    ),
    Environment(
        id = "680c0510d10bbc79144edbbb",
        name = "Bosque",
        image = "https://example.com/forest.jpg"
    ),
    Environment(
        id = "680c0510d10bbc79144edbbc",
        name = "Ártico",
        image = "https://example.com/arctic.jpg"
    ),
    Environment(
        id = "680c0510d10bbc79144edbbd",
        name = "Desierto",
        image = "https://example.com/desert.jpg"
    )
)