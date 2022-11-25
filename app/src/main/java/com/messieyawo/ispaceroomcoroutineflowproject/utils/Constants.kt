package com.messieyawo.ispaceroomcoroutineflowproject.utils

object Constants {
    //endpoints
    const val BASE_URL = "https://api.deezer.com/"
    const val GENRE_ENDPOINT = "/genre"
    const val GENRE_ARTISTS_ENDPOINT = "/genre/{genreId}/artists"
    const val ARTIST_TOP_TRACKS_ENDPOINT = "/genre/artist/{artistId}/top?limit=50"
    const val ARTIST_NEXT_TOP_TRACKS_ENDPOINT = "/genre/artist/{artistId}/top?limit=50&{nextLink}"

    //what do you need from teh api
    const val GET_GENRES = "genres"
    const val GET_ARTISTS = "artists"
    const val GET_TRACKS = "tracks"
    const val GET_NEXT_TRACKS = "nextTracks"
}