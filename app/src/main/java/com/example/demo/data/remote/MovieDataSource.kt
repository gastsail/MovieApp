package com.example.demo.data.remote

import com.example.demo.core.Resource
import com.example.demo.data.model.MovieList

class MovieDataSource {

    suspend fun getUpcomingMovies(): Resource<MovieList> {
        return Resource.Success(MovieList())
    }
}