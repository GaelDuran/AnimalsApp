package com.example.animalsapp.screens

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.animalsapp.models.Animals
import com.example.animalsapp.services.AnimalsService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    var animals by remember { mutableStateOf<Animals?>(null) }
    val scope = rememberCoroutineScope()

    val BASE_URL = "https://animals.juanfrausto.com/api/animals"

    LaunchedEffect(true) {
        scope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val animalServices = retrofit.create(AnimalsService::class.java)
                animals = animalServices.getAnimals()
            } catch (e: Exception) {
                Log.e("HomeScreen", "Error al obtener los animales", e)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(innerPadding = PaddingValues())
}