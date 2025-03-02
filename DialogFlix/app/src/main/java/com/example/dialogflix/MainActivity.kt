package com.example.dialogflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dialogflix.screens.DetailScreen
import com.example.dialogflix.ui.theme.DialogFlixTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogFlixTheme {
                DetailScreen()
                }
            }
        }
    }