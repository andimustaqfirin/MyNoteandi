package com.andi.mynote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatase : RoomDatabase(){

    abstract fun noteDao():NoteDao

    companion object{
        private var INSTANCE: NoteDatase? = null
        fun getInstance(context: Context):NoteDatase?{
            if (INSTANCE == null){
                synchronized(NoteDatase::class){
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            NoteDatase::class.java,
                            "NoteDatabase.db"
                        ).build()
                }
            }
            return INSTANCE
        }
    }
}