package com.example.animalsapp.services

import android.os.Environment
import retrofit2.http.GET

interface EnvironmentService {
    @GET("environment")
    suspend fun getEnvironment(): List<Environment>
}