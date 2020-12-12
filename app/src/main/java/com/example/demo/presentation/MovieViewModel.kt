package com.example.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.demo.core.Resource
import com.example.demo.data.model.MovieList
import com.example.demo.domain.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val repo: MovieRepository) : ViewModel() {

    fun fetchMainScreenMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(Triple(repo.getUpcomingMovies(),repo.getTopRatedMovies(),repo.getPopularMovies())))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class MovieViewModelFactory(private val repo: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}