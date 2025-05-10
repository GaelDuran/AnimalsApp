package com.example.animalsapp.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animalsapp.components.AnimalCard
import com.example.animalsapp.models.Animals
import kotlin.collections.filter
import androidx.compose.foundation.lazy.items

@Composable
fun EnvironmentScreen(
    environmentId: String,
    animals: List<Animals>,
    onAnimalClick: (Animals) -> Unit
) {
    val filteredAnimals = animals.filter { it.environmentId == environmentId }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(filteredAnimals) { animal ->
            AnimalCard(animal = animal, onClick = { onAnimalClick(animal) })
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
