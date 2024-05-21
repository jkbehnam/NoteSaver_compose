package com.example.composetemp.domain.repository

import com.example.composetemp.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllNotes(): Flow<List<Note>>
    fun getNoteById(id:Long): Flow<Note>
    fun getBookedMarkedNote(): Flow<List<Note>>
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun insertNote(note: Note)
}