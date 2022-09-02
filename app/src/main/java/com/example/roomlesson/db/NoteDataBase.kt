package com.example.roomlesson.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomlesson.db.dao.NotDao
import com.example.roomlesson.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun getNoteDao(): NotDao

    companion object{
        private var database: NoteDataBase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase{
            return if(database == null){
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db").build()
                database as NoteDataBase
            } else{
                database as NoteDataBase}
        }
    }
}