package com.example.animalsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.animalsapp.components.AnimalDetail
import com.example.animalsapp.models.Animals
import com.example.animalsapp.services.AnimalsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalDetailScreen(animalId: String) {
    var animal by remember { mutableStateOf<Animals?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://animals.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AnimalsService::class.java)
            val animals = withContext(Dispatchers.IO) { service.getAnimals() }
            animal = animals.find { it.id == animalId }
        } catch (e: Exception) {
            animal = null
        } finally {
            isLoading = false
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Detalles del Animal") }) }
    ) { padding ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (animal == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Animal no encontrado")
            }
        } else {
            LazyColumn(
                contentPadding = padding,
                modifier = Modifier
                    .background(Color(0xFF005500))
                    .fillMaxSize()
            ) {
                item {
                    AnimalDetail(animal = animal!!)
                }
            }
        }
    }
}