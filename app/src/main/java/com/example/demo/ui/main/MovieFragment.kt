package com.example.demo.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.R
import com.example.demo.core.Resource
import com.example.demo.data.model.Movie
import com.example.demo.data.remote.MovieDataSource
import com.example.demo.databinding.FragmentMovieBinding
import com.example.demo.domain.MovieRepositoryImpl
import com.example.demo.domain.RetrofitClient
import com.example.demo.presentation.MovieViewModel
import com.example.demo.presentation.MovieViewModelFactory


class MovieFragment : Fragment(R.layout.fragment_movie), UpcomingMoviesAdapter.OnMovieClickListener {

    private lateinit var concatAdapter: ConcatAdapter
    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(MovieRepositoryImpl(MovieDataSource(RetrofitClient.webservice))) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)
        viewModel.fetchUpcomingMovies().observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rvMovies.layoutManager = LinearLayoutManager(requireContext())
                    binding.rvMovies.adapter = ConcatAdapter(MovieAdapter(UpcomingMoviesAdapter(it.data.results,this)))
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.e("FetchError", "Error: $it.exception ")
                    Toast.makeText(requireContext(), "Error: ${it.exception}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    override fun onMovieClick(movie: Movie) {
        Toast.makeText(
            requireContext(),
            "Movie clicked: ${movie.original_title}",
            Toast.LENGTH_SHORT
        ).show()
    }
}