package com.example.animalsapp.models

import com.google.gson.annotations.SerializedName

data class Animals(
    @SerializedName("_id") val id: String,
    val name: String,
    val image: String,
    val description: String,
    val imageGallery: List<String>,
    val environmentId: String,
    val facts: List<String>,
)

