package com.example.demo.data.local

import com.example.demo.data.model.MovieEntity
import com.example.demo.data.model.MovieList
import com.example.demo.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {

    suspend fun getUpcomingMovies(): MovieList {
        return movieDao.getUpcomingMovies().toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getTopRatedMovies().toMovieList()
    }

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getPopularMovies().toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity) {
        movieDao.saveMovie(movie)
    }
}