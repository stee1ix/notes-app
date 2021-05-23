package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // If there are same entries being inserted then it will ignore
    suspend fun insert(note: Note)  /*suspend means the function will run in the background and won't interrupt with the UI thread*/

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}