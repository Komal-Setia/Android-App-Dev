package com.example.quoteapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quoteapp.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn {
        items(data) {
            QuoteListItem(quote = it, onClick)
        }
    }
}