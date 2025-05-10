package com.example.animalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.animalsapp.screens.EnvironmentScreen
import com.example.animalsapp.screens.HomeScreen
import com.example.animalsapp.ui.theme.AnimalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalsAppTheme {
                var selectedScreen by remember { mutableStateOf("Animals") }
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize().background(Color(0xFF0D0D2B)),
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    bottomBar = {
                        NavigationBar(
                            containerColor = Color(0xFF0D0D2B).copy(alpha = 0.9f)
                        ) {
                            NavigationBarItem(
                                selected = selectedScreen == "Animals",
                                onClick = {
                                    selectedScreen = "Animals"
                                    navController.navigate("Animals")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = "Animales",
                                        tint = Color.White,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                label = { Text("Inicio", color = Color.White) },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White.copy(alpha = 0.2f)
                                )
                            )
                            NavigationBarItem(
                                selected = selectedScreen == "environment",
                                onClick = {
                                    selectedScreen = "environment"
                                    navController.navigate("environment")
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.LocationOn,
                                        contentDescription = "Ambientes",
                                        tint = Color.White,
                                        modifier = Modifier.size(30.dp)
                                    )
                                },
                                label = { Text("Ambientes", color = Color.White) },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.White.copy(alpha = 0.2f)
                                )
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Animals",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("Animals") {
                            HomeScreen(innerPadding = innerPadding)
                        }
                        composable("environment") {
                            EnvironmentScreen(
                                environmentId = "1",
                                animals = listOf(),
                                onAnimalClick = {}
                            )
                        }
                    }
                }
            }
        }
    }
}
