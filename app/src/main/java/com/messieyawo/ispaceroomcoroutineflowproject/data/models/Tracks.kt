package com.messieyawo.ispaceroomcoroutineflowproject.data.models

import com.google.gson.annotations.SerializedName

data class Tracks(
    @SerializedName("data")
    val tracks : List<Track?>,
    @SerializedName("total")
    val total : Int,
    @SerializedName("prev")
    val prev : String,
    @SerializedName("next")
    val next : String,
)

data class Track(
    @SerializedName("id")
    val id: Int,
    @SerializedName("readable")
    val readable: Boolean,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_short")
    val title_short: String,
    @SerializedName("title_version")
    val title_version: String,
    @SerializedName("link")
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    @SerializedName("preview")
    val preview: String,
    val contributors: List<Contributor>,
    val md5_image: String,
    val artist: ArtistX,
    val album: Album,
    val type: String
)

data class ArtistX(
    val id: Int,
    val name: String,
    val tracklist: String,
    val type: String
)

data class Contributor(
    val id: Int,
    val link: String,
    val name: String,
    val picture: String,
    val picture_big: String,
    val picture_medium: String,
    val picture_small: String,
    val picture_xl: String,
    val radio: Boolean,
    val role: String,
    val share: String,
    val tracklist: String,
    val type: String
)

data class Album(
    val cover: String,
    val cover_big: String,
    val cover_medium: String,
    val cover_small: String,
    val cover_xl: String,
    val id: Int,
    val md5_image: String,
    val title: String,
    val tracklist: String,
    val type: String
)