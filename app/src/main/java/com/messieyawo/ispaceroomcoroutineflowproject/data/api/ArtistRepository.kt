package com.messieyawo.ispaceroomcoroutineflowproject.data.api

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Artists
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genres
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Tracks
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArtistRepository(private val genreId: String) {
    val artists = MutableLiveData<Artists>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getArtists(genreId)
        }
    }

    @WorkerThread
    suspend fun getArtists(genreId: String){
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
        val artistList = service.fetchArtists(genreId).body()?: emptyList<Artists>()

        artists.postValue(artistList as Artists)
    }
}