package com.example.composetemp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetemp.data.local.model.Note
import com.example.composetemp.domain.use_cases.AddNoteUseCase
import com.example.composetemp.domain.use_cases.DeleteNoteUseCase
import com.example.composetemp.domain.use_cases.GetAllNotesUseCase
import com.example.composetemp.domain.use_cases.UpdateNoteUseCase
import com.example.composetemp.state.ScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase:DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
):ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
            val state:StateFlow<HomeState> = _state.asStateFlow()

    init {
        getAllNotes()
    }

    private fun getAllNotes(){
       getAllNotesUseCase()
           .onEach {
               _state.value= HomeState(notes = ScreenViewState.Success(it))
           }
           .catch {
               _state.value= HomeState(notes = ScreenViewState.Error(it.message))
           }
           .launchIn(viewModelScope)

    }

    fun deleteNote(id:Long)= viewModelScope.launch {
        deleteNoteUseCase(id)
    }

      fun onBookedMarkedChange(note:Note) {
       viewModelScope.launch {
           updateNoteUseCase(note.copy(isBookedMarked = !note.isBookedMarked))
       }
    }
    
}

data class HomeState(
    val notes: ScreenViewState<List<Note>> = ScreenViewState.Loading
)
