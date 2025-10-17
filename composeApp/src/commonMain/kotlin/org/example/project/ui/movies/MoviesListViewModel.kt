package org.example.project.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.repository.MoviesRepository
import org.example.project.domain.model.MovieSection

class MoviesListViewModel(
    private val moviesRepository: MoviesRepository
): ViewModel() {

    private val _movieListState = MutableStateFlow<MoviesListState>(MoviesListState.loading)
    val moviesListState = _movieListState.asStateFlow()

    init {
        getMovieSection()
    }

    private fun getMovieSection() {
        viewModelScope.launch {
            try {
                val movieSections = moviesRepository.getMoviesSections()
                _movieListState.update {
                    MoviesListState.Sucess(movieSections)
                }
            } catch (e: Exception) {
                _movieListState.update {
                    MoviesListState.Error(e.message ?: "Unknown error")
                }
            }
        }
    }

    sealed interface MoviesListState {
        data object loading: MoviesListState
        data class Sucess(val movieSection: List<MovieSection>) : MoviesListState
        data class Error(val message: String) : MoviesListState
    }

}