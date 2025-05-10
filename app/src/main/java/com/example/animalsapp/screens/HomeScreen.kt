package com.example.animalsapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animalsapp.components.AnimalCard
import com.example.animalsapp.models.Animals
import com.example.animalsapp.models.mockAnimalList
import com.example.animalsapp.services.AnimalsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController) {
    var animals by remember { mutableStateOf<List<Animals>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    val BASE_URL = "https://animals.juanfrausto.com/api/"

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val animalServices = retrofit.create(AnimalsService::class.java)
            animals = withContext(Dispatchers.IO) {
                animalServices.getAnimals()
            }
        } catch (e: Exception) {
            Log.e("HomeScreen", "Error al obtener los animales", e)
            animals = mockAnimalList // Usar mock como respaldo
        } finally {
            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF005500))
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else if (animals.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No se encontraron animales")
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(animals) { animal ->
                    AnimalCard(
                        animal = animal,
                        onClick = {
                            navController.navigate("animalDetail/${animal.id}")
                        }
                    )
                }
            }
        }
    }
}