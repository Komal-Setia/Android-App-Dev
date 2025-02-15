package com.example.quoteapp

import android.content.Context
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {
    var data = emptyArray<Quote>()

    fun loadAssetsFromJsonFile(conext: Context){
        val inputStream = conext.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.defaultCharset())
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
    }
}