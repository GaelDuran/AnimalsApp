package com.example.animalsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animalsapp.components.AnimalCard
import com.example.animalsapp.models.Animals
import com.example.animalsapp.services.AnimalsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalsScreen() {
    var animals by remember { mutableStateOf<List<Animals>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isLoading = true
        animals = try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://animals.juanfrausto.com/api/animals") // Reemplaza con tu base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(AnimalsService::class.java)
            withContext(Dispatchers.IO) {
                service.getAnimals()
            }
        } catch (e: Exception) {
            emptyList()
        }
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Animales") })
        }
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
        } else {
            LazyColumn(
                contentPadding = padding,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(animals) { animal ->
                    AnimalCard(animal = animal, onClick = {
                    })
                }
            }
        }
    }
}
