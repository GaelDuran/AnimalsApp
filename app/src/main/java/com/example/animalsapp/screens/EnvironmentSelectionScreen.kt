package com.example.animalsapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animalsapp.components.EnvironmentCard
import com.example.animalsapp.models.Environment
import com.example.animalsapp.models.mockEnvironmentList
import com.example.animalsapp.services.EnvironmentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun EnvironmentSelectionScreen(navController: NavController) {
    var environments by remember { mutableStateOf<List<Environment>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    val BASE_URL = "https://animals.juanfrausto.com/api/"

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val environmentService = retrofit.create(EnvironmentService::class.java)
            environments = withContext(Dispatchers.IO) {
                environmentService.getEnvironment()
            }
        } catch (e: Exception) {
            environments = mockEnvironmentList // Usar mock como respaldo
        } finally {
            isLoading = false
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    Scaffold(
        topBar = { TopAppBar(title = { Text("Ambientes") }) }
    ) { padding ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                androidx.compose.material3.CircularProgressIndicator()
            }
        } else if (environments.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No se encontraron ambientes")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .background(Color(0xFF005500))
                    .padding(padding)
                    .padding(16.dp)
            ) {
                items(environments) { environment ->
                    EnvironmentCard(
                        environment = environment,
                        onClick = { navController.navigate("environmentDetail/${environment.id}") }
                    )
                }
            }
        }
    }
}