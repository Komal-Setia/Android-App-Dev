package com.example.dialogflix.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dialogflix.viewmodels.DetailViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen() {
    val detailViewModel : DetailViewModel = hiltViewModel()
    val dialogs =  detailViewModel.dialogs.collectAsState()
    LazyColumn( content = {
        items(dialogs.value){
            DialogListItem(dialog = it.dialogue, character = it.character)
        }
    })
}

@Composable
fun DialogListItem(dialog: String, character: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
                text = dialog,
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 6.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = character,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                fontWeight = FontWeight.Thin,
                style = MaterialTheme.typography.bodySmall


            )
        }
    )
}