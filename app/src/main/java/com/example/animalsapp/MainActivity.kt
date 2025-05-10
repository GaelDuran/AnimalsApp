package com.example.animalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animalsapp.models.Animals
import com.example.animalsapp.screens.AnimalDetailScreen
import com.example.animalsapp.screens.EnvironmentScreen
import com.example.animalsapp.screens.EnvironmentSelectionScreen
import com.example.animalsapp.screens.HomeScreen
import com.example.animalsapp.ui.theme.AnimalsAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalsAppTheme {
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
                        val animalServices =
                            retrofit.create(com.example.animalsapp.services.AnimalsService::class.java)
                        animals = withContext(Dispatchers.IO) {
                            animalServices.getAnimals()
                        }
                    } catch (e: Exception) {
                        animals = com.example.animalsapp.models.mockAnimalList
                    } finally {
                        isLoading = false
                    }
                }

                val navController = rememberNavController()
                val currentRoute by navController.currentBackStackEntryAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color(0xFF005500),
                    bottomBar = {
                        NavigationBar(
                            containerColor = Color(0xFFF5E050)
                        ) {
                            NavigationBarItem(
                                selected = currentRoute?.destination?.route == "Animals",
                                onClick = {
                                    navController.navigate("Animals") {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.Home,
                                        contentDescription = "Inicio",
                                        tint = Color.Black,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                label = { Text("Inicio", color = Color.Black) },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White.copy(alpha = 0.2f)
                                )
                            )
                            NavigationBarItem(
                                selected = currentRoute?.destination?.route == "environmentSelection",
                                onClick = {
                                    navController.navigate("environmentSelection") {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.LocationOn,
                                        contentDescription = "Ambientes",
                                        tint = Color.Black,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                label = { Text("Ambientes", color = Color.Black) },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White.copy(alpha = 0.2f)
                                )
                            )
                        }
                    }
                ) { innerPadding ->
                    if (isLoading) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding),
                            contentAlignment = androidx.compose.ui.Alignment.Center
                        ) {
                            androidx.compose.material3.CircularProgressIndicator()
                        }
                    } else {
                        NavHost(
                            navController = navController,
                            startDestination = "Animals",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("Animals") {
                                HomeScreen(
                                    innerPadding = innerPadding,
                                    navController = navController
                                )
                            }
                            composable("environmentSelection") {
                                EnvironmentSelectionScreen(navController = navController)
                            }
                            composable("environmentDetail/{environmentId}") { backStackEntry ->
                                val environmentId =
                                    backStackEntry.arguments?.getString("environmentId") ?: ""
                                EnvironmentScreen(
                                    environmentId = environmentId,
                                    animals = animals,
                                    navController = navController
                                )
                            }
                            composable("animalDetail/{animalId}") { backStackEntry ->
                                val animalId = backStackEntry.arguments?.getString("animalId") ?: ""
                                AnimalDetailScreen(animalId = animalId)
                            }
                        }
                    }
                }
            }
        }
    }
}