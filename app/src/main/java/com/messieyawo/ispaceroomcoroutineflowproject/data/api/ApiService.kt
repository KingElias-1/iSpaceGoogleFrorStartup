package com.messieyawo.ispaceroomcoroutineflowproject.data.api

import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Artists
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Genres
import com.messieyawo.ispaceroomcoroutineflowproject.data.models.Tracks
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.ARTIST_NEXT_TOP_TRACKS_ENDPOINT
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.ARTIST_TOP_TRACKS_ENDPOINT
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GENRE_ARTISTS_ENDPOINT
import com.messieyawo.ispaceroomcoroutineflowproject.utils.Constants.GENRE_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(GENRE_ENDPOINT)
    suspend fun fetchAllGenres(
    ): Response<Genres>

    @GET(GENRE_ARTISTS_ENDPOINT)
    suspend fun fetchArtists(@Path("genreId") id:String
    ): Response<Artists>

    @GET(ARTIST_TOP_TRACKS_ENDPOINT)
    suspend fun fetchArtistTracks(@Path("artistId") id:String
    ): Response<Tracks>

    @GET(ARTIST_NEXT_TOP_TRACKS_ENDPOINT)
    suspend fun fetchArtistNextTracks(@Path("nextLink") next:String
    ): Response<Tracks>
}