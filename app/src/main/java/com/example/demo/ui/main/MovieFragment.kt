package com.example.demo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import com.example.demo.R


class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}