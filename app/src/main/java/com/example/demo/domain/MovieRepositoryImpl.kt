package com.example.demo.domain

import com.example.demo.core.Resource
import com.example.demo.data.remote.MovieDataSource
import com.example.demo.data.model.MovieList

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()
    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()
    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}