package com.example.composetemp.domain.use_cases

import com.example.composetemp.data.local.model.Note
import com.example.composetemp.domain.repository.Repository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private  val repository: Repository
) {
    suspend operator fun invoke(note: Note) = repository.insertNote(note)
}