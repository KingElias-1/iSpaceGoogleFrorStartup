package com.messieyawo.ispaceroomcoroutineflowproject.data.api

import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Artist
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genres
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.GENRE_ENDPOINT)
    suspend fun fetchAllGenres(
    ): Response<Genres>

    @GET(Constants.POP_ARTISTS)
    suspend fun fetchArtists(
    ): Response<List<Artist>>
}