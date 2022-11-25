package com.messieyawo.ispaceroomcoroutineflowproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.messieyawo.ispaceroomcoroutineflowproject.adapters.ArtistAdapter
import com.messieyawo.ispaceroomcoroutineflowproject.databinding.FragmentArtistsBinding
import com.messieyawo.ispaceroomcoroutineflowproject.viewmodels.HomeViewModel

class ArtistsFragment : Fragment() {
    private lateinit var artistsBinding: FragmentArtistsBinding
    private lateinit var artistVM: HomeViewModel
    private lateinit var genreId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        artistsBinding = FragmentArtistsBinding.inflate(inflater, container, false)

        //get genre from arguement
        val args: ArtistsFragmentArgs by navArgs()
        genreId = args.genre.id.toString()
        artistsBinding.genreTV.text = args.genre.name

        artistVM = HomeViewModel(requireActivity().application, genreId)

        artistsBinding.artistRV.layoutManager = LinearLayoutManager(requireActivity())

        artistVM.artistsList.observe(viewLifecycleOwner, Observer{ artists ->
            val artistAdapter = ArtistAdapter(requireActivity(), artists)
            artistsBinding.artistRV.adapter = artistAdapter
        })

        return artistsBinding.root
    }

}