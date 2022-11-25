package com.messieyawo.ispaceroomcoroutineflowproject.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.messieyawo.ispaceroomcoroutineflowproject.data.api.ArtistRepository
import com.messieyawo.ispaceroomcoroutineflowproject.data.api.Repository
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genre
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_ARTISTS
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_GENRES
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_TRACKS

class HomeViewModel(application: Application, genreId: String=""): ViewModel() {

    val genreRepo = Repository()
    var artistRepo = ArtistRepository(genreId)

    val genresList = genreRepo.genres
    val artistsList = artistRepo.artists

    class HomeViewModelFactory(private val application: Application ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                HomeViewModel(application) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}