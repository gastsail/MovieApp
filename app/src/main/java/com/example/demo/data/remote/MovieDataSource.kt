package com.example.demo.data.remote

import com.example.demo.application.AppConstants
import com.example.demo.core.Resource
import com.example.demo.data.model.MovieList
import com.example.demo.domain.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): Resource<MovieList> {
        return Resource.Success(webService.getUpcomingMovies(AppConstants.API_KEY))
    }
}