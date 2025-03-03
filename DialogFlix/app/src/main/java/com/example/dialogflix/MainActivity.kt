package com.example.dialogflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dialogflix.screens.CategoryScreen
import com.example.dialogflix.screens.DetailScreen
import com.example.dialogflix.screens.SplashScreen
import com.example.dialogflix.ui.theme.DialogFlixTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogFlixTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable(route = "splash") {
            SplashScreen(onSplashFinished = {
                navController.navigate("category") {
                    popUpTo("splash") {
                        inclusive = true //Remove splash from back stack
                    }
                }
            })
        }
        composable(route = "category") {
            CategoryScreen(onClick = {
                //Anonymous function
                navController.navigate("detail/${it}")
            })
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )) {
            DetailScreen()
        }

    }
}