package com.example.animalsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.animalsapp.components.AnimalCard
import com.example.animalsapp.models.Animals
import com.example.animalsapp.models.Environment
import com.example.animalsapp.models.mockEnvironmentList
import com.example.animalsapp.services.EnvironmentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnvironmentScreen(environmentId: String, animals: List<Animals>, navController: NavController) {
    var environment by remember { mutableStateOf<Environment?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://animals.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(EnvironmentService::class.java)
            val environments = withContext(Dispatchers.IO) { service.getEnvironment() }
            environment = environments.find { it.id == environmentId }
        } catch (e: Exception) {
            environment = mockEnvironmentList.find { it.id == environmentId }
        } finally {
            isLoading = false
        }
    }

    val filteredAnimals = animals.filter { it.environmentId == environmentId }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Ambiente") }) }
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
        } else if (environment == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Ambiente no encontrado")
            }
        } else {
            LazyColumn(
                contentPadding = padding,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .background(Color(0xFF005500))
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = environment!!.image,
                            contentDescription = environment!!.name,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Text(
                        text = environment!!.name,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Text(
                        text = environment!!.description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Animales en este ambiente",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                items(filteredAnimals) { animal ->
                    AnimalCard(
                        animal = animal,
                        showDescription = false,
                        onClick = { navController.navigate("animalDetail/${animal.id}") }
                    )
                }
            }
        }
    }
}