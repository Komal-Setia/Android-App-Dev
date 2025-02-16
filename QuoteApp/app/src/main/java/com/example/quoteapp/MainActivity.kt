package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Downloading
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quoteapp.screens.QuoteDetailScreen
import com.example.quoteapp.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            // for performance running task in background thread
            delay(10000)
            DataManager.loadAssetsFromJsonFile(applicationContext)
        }


        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {

        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)
        ) {
            Image(
                imageVector = Icons.Filled.Downloading, contentDescription = "loading"
            )
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 60.dp)
            )
        }
    }
}

enum class Pages {
    LISTING, DETAIL
}