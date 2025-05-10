package com.example.animalsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animalsapp.components.AnimalCard
import com.example.animalsapp.models.Animals

@Composable
fun EnvironmentScreen(
    environmentId: String,
    animals: List<Animals>,
    onAnimalClick: (Animals) -> Unit
) {
    val filteredAnimals = animals.filter { it.environmentId == environmentId }

    @OptIn(ExperimentalMaterial3Api::class)
    Scaffold(
        topBar = { TopAppBar(title = { Text("Ambiente") }) }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF005500))
                .padding(16.dp)
        ) {
            items(filteredAnimals) { animal ->
                AnimalCard(animal = animal, onClick = { onAnimalClick(animal) })
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
        if (filteredAnimals.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No hay animales en este ambiente")
            }
        }
    }
}