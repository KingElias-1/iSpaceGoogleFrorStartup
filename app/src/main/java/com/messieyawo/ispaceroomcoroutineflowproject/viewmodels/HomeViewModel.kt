package com.messieyawo.ispaceroomcoroutineflowproject.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.messieyawo.ispaceroomcoroutineflowproject.data.api.Repository
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genre

class HomeViewModel(application: Application): ViewModel() {

    val repo = Repository(application)
    val genresList = repo.genres

    val genres = MutableLiveData<List<Genre>>()

    class HomeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                HomeViewModel(application) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}