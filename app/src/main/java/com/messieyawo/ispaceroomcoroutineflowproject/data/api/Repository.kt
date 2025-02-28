package com.messieyawo.ispaceroomcoroutineflowproject.data.api

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide.init
import com.google.gson.GsonBuilder
import com.messieyawo.ispaceroomcoroutineflowproject.data.api.RetrofitInstance.Companion.gson
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Artists
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genre
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genres
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Tracks
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_ARTISTS
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_GENRES
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_NEXT_TRACKS
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GET_TRACKS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository() {

    val genres = MutableLiveData<Genres>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getGenres()
        }
    }

    @WorkerThread
    suspend fun getGenres(){
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val gson = GsonBuilder()
            .create()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val service = retrofit.create(ApiService::class.java)
        val genresList = service.fetchAllGenres().body()?: emptyList<Genres>()

        genres.postValue(genresList as Genres)
    }
}