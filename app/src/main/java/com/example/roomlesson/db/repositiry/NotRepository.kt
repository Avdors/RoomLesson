package com.example.roomlesson.db.repositiry

import androidx.lifecycle.LiveData
import com.example.roomlesson.model.NoteModel

interface NotRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
}