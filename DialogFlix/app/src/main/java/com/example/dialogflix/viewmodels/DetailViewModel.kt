package com.example.dialogflix.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dialogflix.models.DialogListItem
import com.example.dialogflix.repository.DialogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DialogRepository,
    private val savedStateHandle: SavedStateHandle): ViewModel() {

        val dialogs : StateFlow<List<DialogListItem>>
            get() = repository.dialogs

        init {
            viewModelScope.launch {
                val category = savedStateHandle.get<String>("category") ?: ""
                repository.getDialogs(category)
            }
        }
}