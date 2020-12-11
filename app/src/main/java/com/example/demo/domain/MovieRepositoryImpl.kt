package com.example.demo.domain

import com.example.demo.core.Resource
import com.example.demo.data.remote.MovieDataSource
import com.example.demo.data.model.MovieList

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {

    override suspend fun getUpcomingMovies(): Resource<MovieList> = dataSource.getUpcomingMovies()
}