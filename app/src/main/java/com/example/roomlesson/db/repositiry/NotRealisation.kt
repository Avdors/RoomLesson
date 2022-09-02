package com.example.roomlesson.db.repositiry

import androidx.lifecycle.LiveData
import com.example.roomlesson.db.dao.NotDao
import com.example.roomlesson.model.NoteModel

class NotRealisation(private val notDao: NotDao): NotRepository {

    override val allNotes: LiveData<List<NoteModel>>
        get() = notDao.getAllNote()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        notDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        notDao.delete(noteModel)
        onSuccess()
    }
}