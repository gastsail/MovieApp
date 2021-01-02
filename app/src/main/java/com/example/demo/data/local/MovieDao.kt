package com.example.demo.data.local

import androidx.room.*
import com.example.demo.data.model.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentity")
    suspend fun getPopularMovies(): List<MovieEntity>

    @Query("SELECT * FROM movieentity")
    suspend fun getTopRatedMovies(): List<MovieEntity>

    @Query("SELECT * FROM movieentity")
    suspend fun getUpcomingMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieEntity)

}