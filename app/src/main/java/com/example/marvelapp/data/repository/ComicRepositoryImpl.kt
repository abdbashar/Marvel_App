package com.example.marvelapp.data.repository

import com.example.marvelapp.data.State
import com.example.marvelapp.data.api.MarvelApi
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class ComicRepositoryImpl : ComicRepository {

    private fun <T> wrapResponse(response: Single<Response<T>>): Single<State<T>> {
        return response.map {
            if (it.isSuccessful) {
                State.Success(it.body())
            } else {
                State.Failure(it.message())
            }
        }

    }
    override fun getCharactersApi() = wrapResponse(MarvelApi.marvelService.getCharacters())

    override fun getCharacterByIdApi(characterId: Int) = wrapResponse(MarvelApi.marvelService.getCharacterById(characterId))

    override fun getComicsByCharacterIdApi(characterId: Int) = wrapResponse(MarvelApi.marvelService.getComicsByCharacterId(characterId))
}