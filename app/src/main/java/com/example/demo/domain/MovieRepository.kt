package com.example.demo.domain

import com.example.demo.core.Resource
import com.example.demo.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies(): Resource<MovieList>
}