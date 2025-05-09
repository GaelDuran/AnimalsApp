package com.example.animalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.animalsapp.ui.theme.AnimalsAppTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AnimalsAppTheme {
//                val navController = rememberNavController()
//                var selectedScreen by remember { mutableStateOf("animals") }

//                Scaffold(
//                    modifier = Modifier.
//                    fillMaxSize())

//                { innerPadding ->
//                    NavHost(
//                        navController = NavController,
//                        startDestination = "animals"
//                    ){
//                        composable("animals") {
//                            AnimaslScreen(innerPadding = innerPadding)
//                        }
//                        composable("enviroment"){
//                            EnvironmentScreen(innerPadding = innerPadding)
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//}
