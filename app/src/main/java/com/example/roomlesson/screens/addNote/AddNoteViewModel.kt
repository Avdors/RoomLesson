package com.example.roomlesson.screens.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomlesson.REPOSITORY
import com.example.roomlesson.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess:()-> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
}