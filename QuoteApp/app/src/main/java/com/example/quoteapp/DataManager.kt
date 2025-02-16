package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {
    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null

    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromJsonFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.defaultCharset())
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}