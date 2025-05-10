package com.example.animalsapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.animalsapp.models.Animals

@Composable
fun AnimalDetail(animal: Animals) {
    Column(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = animal.image,
            contentDescription = animal.name,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
        Text(
            text = animal.name,
            modifier = Modifier.padding(top = 16.dp),
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge
        )
        Text(
            text = animal.description,
            modifier = Modifier.padding(top = 8.dp),
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Hechos Interesantes",
            modifier = Modifier.padding(top = 16.dp),
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )
        animal.facts.forEachIndexed { index, fact ->
            Text(
                text = "${index + 1}. $fact",
                modifier = Modifier.padding(top = 4.dp),
                style = androidx.compose.material3.MaterialTheme.typography.bodySmall
            )
        }
        Text(
            text = "Galería de Imágenes",
            modifier = Modifier.padding(top = 16.dp),
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )
        LazyRow(modifier = Modifier.padding(top = 8.dp)) {
            items(animal.imageGallery) { imageUrl ->
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Imagen de galería",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .padding(end = 8.dp),
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop
                )
            }
        }
    }
}