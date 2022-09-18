package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.BaseResponse
import com.example.marvelapp.data.model.characters.Result
import io.reactivex.rxjava3.core.Single

interface ComicRepository {
    fun getCharactersApi(): Single<State<BaseResponse<Result>>>
    fun getCharacterByIdApi(characterId: Int): Single<State<BaseResponse<Result>>>
    fun getComicsByCharacterIdApi(characterId: Int): Single<State<BaseResponse<Result>>>
}



