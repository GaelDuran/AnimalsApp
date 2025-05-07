package com.example.animalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animalapp.screens.AnimalDetailScreen
import com.example.animalapp.screens.AnimalListScreen
import com.example.animalapp.screens.EnvironmentDetailScreen
import com.example.animalapp.screens.EnvironmentListScreen
import com.example.animalapp.theme.AnimalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalAppTheme {
                var selectedScreen by remember { mutableStateOf("animals") }
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF0D0D2B)),
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    bottomBar = {
                        NavigationBar(
                            containerColor = Color(0xFF0D0D2B).copy(alpha = 0.9f)
                        ) {
                            NavigationBarItem(
                                selected = selectedScreen == "animals",
                                onClick = {
                                    selectedScreen = "animals"
                                    navController.navigate("animals")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.List,
                                        contentDescription = "Animals",
                                        tint = Color.White,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White.copy(alpha = 0.2f)
                                )
                            )
                            NavigationBarItem(
                                selected = selectedScreen == "environments",
                                onClick = {
                                    selectedScreen = "environments"
                                    navController.navigate("environments")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Place,
                                        contentDescription = "Environments",
                                        tint = Color.White,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White.copy(alpha = 0.2f)
                                )
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "animals",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("animals") { AnimalListScreen(navController) }
                        composable("environments") { EnvironmentListScreen(navController) }
                        composable("animal_detail/{animalId}") { backStackEntry ->
                            AnimalDetailScreen(
                                animalId = backStackEntry.arguments?.getString("animalId") ?: ""
                            )
                        }
                        composable("environment_detail/{environmentId}") { backStackEntry ->
                            EnvironmentDetailScreen(
                                environmentId = backStackEntry.arguments?.getString("environmentId") ?: ""
                            )
                        }
                    }
                }
            }
        }
    }
}