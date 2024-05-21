package com.example.composetemp.domain.use_cases

import com.example.composetemp.domain.repository.Repository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(id:Long)= repository.deleteNote(id)
}