package com.example.animalsapp.services

import com.example.animalsapp.models.Animals
import com.example.animalsapp.models.Habitat

interface AnimalsService {
    @GET("animals")
    suspend fun getAnimals(): Animals

    @GET("habitat")
    suspend fun getHabitat(): Habitat
}