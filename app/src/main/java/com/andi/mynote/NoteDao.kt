package com.andi.mynote


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("SELECT * from note")
    fun getAllnote(): List<NoteModel>

    @Insert(onConflict = REPLACE)
    fun insertNote(note: NoteModel)

    @Delete
    fun deleteNote (note: NoteModel)

    @Query("UPDATE note SET title =:noteTitle, message =: notMessage,WHERE id =:notId")
    fun updateNote(noteTitle:String, noteMessage:String, noteId:Long)
}