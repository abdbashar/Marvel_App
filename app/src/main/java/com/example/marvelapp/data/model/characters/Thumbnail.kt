package com.example.marvelapp.data.model.characters


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String?,
    @SerializedName("path")
    val path: String?
){
    fun loadImage() = "$path.$extension"
}