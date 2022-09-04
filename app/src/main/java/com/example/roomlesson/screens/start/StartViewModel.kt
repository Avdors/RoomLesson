package com.example.roomlesson.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.roomlesson.REPOSITORY
import com.example.roomlesson.db.NoteDataBase
import com.example.roomlesson.db.repositiry.NotRealisation
import com.example.roomlesson.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {
    val context = application

    fun initDatabase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NotRealisation(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNotes
    }
}