package com.example.demo.data.remote

import com.example.demo.application.AppConstants
import com.example.demo.core.Resource
import com.example.demo.data.model.MovieList
import com.example.demo.domain.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies(): MovieList {
        return webService.getUpcomingMovies(AppConstants.API_KEY)
    }

    suspend fun getTopRatedMovies(): MovieList {
        return webService.getTopRatedMovies(AppConstants.API_KEY)
    }

    suspend fun getPopularMovies(): MovieList {
        return webService.getPopulardMovies(AppConstants.API_KEY)
    }
}