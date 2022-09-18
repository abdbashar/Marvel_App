package com.example.marvelapp.data.api

import com.example.marvelapp.data.model.BaseResponse
import com.example.marvelapp.data.model.characters.Result
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {
    @GET("characters")
    fun getCharacters(): Single<Response<BaseResponse<Result>>>

    @GET("characters/{characterId}")
    fun getCharacterById(@Path("characterId") characterId: Int): Single<Response<BaseResponse<Result>>>

    @GET("characters/{characterId}/comics")
    fun getComicsByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<Response<BaseResponse<Result>>>
}

