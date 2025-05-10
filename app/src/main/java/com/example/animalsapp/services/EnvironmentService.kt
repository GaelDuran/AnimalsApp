package com.example.animalsapp.services

import com.example.animalsapp.models.Environment
import retrofit2.http.GET

interface EnvironmentService {
    @GET("environment")
    suspend fun getEnvironment(): List<Environment>
}