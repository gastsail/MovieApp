package com.example.demo.domain

import com.example.demo.core.Resource
import com.example.demo.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
}