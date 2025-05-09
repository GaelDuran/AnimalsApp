package com.example.animalsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animalsapp.models.Animals

@Composable
fun HomeScreen(animals: List<Animals>, onAnimalClick: (Animals) -> Unit, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B5E20))
            .padding(16.dp)
    ){}
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(innerPadding = PaddingValues())
}