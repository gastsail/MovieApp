package com.example.demo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.demo.core.Resource
import com.example.demo.domain.MovieRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MovieViewModel(private val repo: MovieRepository): ViewModel() {

    fun fetchUpcomingMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try{
            emit(repo.getUpcomingMovies())
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }


}