package com.example.dialogflix.repository

import com.example.dialogflix.api.DialogFlixAPI
import com.example.dialogflix.models.DialogListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DialogRepository @Inject constructor(private val dialogFlixAPI: DialogFlixAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
    get() = _categories

    private val _dialogs = MutableStateFlow<List<DialogListItem>>(emptyList())
    val dialogs : StateFlow<List<DialogListItem>>
        get() = _dialogs


    suspend fun getCategories() {
        val response = dialogFlixAPI.getCategories()
        if(response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getDialogs(category: String) {
        val response = dialogFlixAPI.getDialogs("dialogues[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body() != null){
            _dialogs.emit(response.body()!!)
        }
    }
}