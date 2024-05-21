package com.example.composetemp.domain.use_cases

import com.example.composetemp.data.local.model.Note
import com.example.composetemp.domain.repository.Repository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(note:Note){
        return repository.updateNote(note)
    }
}
