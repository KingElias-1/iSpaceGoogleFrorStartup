package com.messieyawo.ispaceroomcoroutineflowproject.data.models


import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("data")
    val genres : List<Genre?>
)