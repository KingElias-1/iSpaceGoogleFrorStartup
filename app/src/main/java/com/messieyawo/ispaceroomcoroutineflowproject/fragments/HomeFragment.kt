package com.messieyawo.ispaceroomcoroutineflowproject.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.messieyawo.ispaceroomcoroutineflowproject.R
import com.messieyawo.ispaceroomcoroutineflowproject.adapters.GenreAdapter
import com.messieyawo.ispaceroomcoroutineflowproject.databinding.FragmentHomeBinding
import com.messieyawo.ispaceroomcoroutineflowproject.viewmodels.HomeViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModel.HomeViewModelFactory(
            requireActivity().application
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        homeBinding.recV.layoutManager = LinearLayoutManager(requireActivity())
        homeViewModel.genresList.observe(viewLifecycleOwner, Observer{ genres ->
            val genreAdapter = GenreAdapter(requireActivity(), genres)
            homeBinding.recV.adapter = genreAdapter
        })

        return homeBinding.root
    }


}