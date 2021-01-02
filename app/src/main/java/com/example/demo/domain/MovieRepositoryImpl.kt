package com.example.demo.domain

import com.example.demo.data.local.LocalMovieDataSource
import com.example.demo.data.model.MovieList
import com.example.demo.data.model.toMovieEntity
import com.example.demo.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getUpcomingMovies(): MovieList {
        dataSourceRemote.getUpcomingMovies().results.forEach {
            dataSourceLocal.saveMovie(it.toMovieEntity("upcoming"))
        }
        return MovieList(dataSourceLocal.getUpcomingMovies().results.filter { it.movie_type == "upcoming" })
    }

    override suspend fun getTopRatedMovies(): MovieList {
        dataSourceRemote.getTopRatedMovies().results.forEach {
            dataSourceLocal.saveMovie(it.toMovieEntity("toprated"))
        }
        return MovieList(dataSourceLocal.getTopRatedMovies().results.filter { it.movie_type == "toprated" })

    }

    override suspend fun getPopularMovies(): MovieList {
        dataSourceRemote.getPopularMovies().results.forEach {
            dataSourceLocal.saveMovie(it.toMovieEntity("popular"))
        }
        return MovieList(dataSourceLocal.getPopularMovies().results.filter { it.movie_type == "popular" })

    }
}