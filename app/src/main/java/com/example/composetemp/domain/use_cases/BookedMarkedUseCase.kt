package com.example.composetemp.domain.use_cases

import com.example.composetemp.data.local.model.Note
import com.example.composetemp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookedMarkedUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<Note>>{
        return repository.getBookedMarkedNote()
    }
}