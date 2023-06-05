package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.ui.theme.NavegacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route){
                        composable(Routes.Pantalla1.route){ Screen1(navigationController) }
                        composable(Routes.Pantalla2.route){ Screen2(navigationController) }
                        composable(Routes.Pantalla3.route){ Screen3(navigationController) }
                        composable("pantalla4/{name}", arguments = listOf(navArgument("name"){type = NavType.IntType})){ backStackEntry ->
                            Screen4(navigationController, backStackEntry.arguments?.getInt("name") ?: 0) }
                    }
                }
            }
        }
    }
}

