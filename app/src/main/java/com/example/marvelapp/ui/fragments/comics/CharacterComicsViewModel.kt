package com.example.marvelapp.ui.fragments.comics

import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.BaseResponse
import com.example.marvelapp.data.model.characters.Result
import com.example.marvelapp.data.repository.ComicRepositoryImpl
import com.example.marvelapp.ui.adapter.OnClickListener
import com.example.marvelapp.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterComicsViewModel : BaseViewModel(), OnClickListener {
    val comics = MutableLiveData<State<BaseResponse<Result>>>()
    private val _repository = ComicRepositoryImpl()


    fun getComics(id: Int) {
        comics.postValue(State.Loading)
        _repository.getComicsByCharacterIdApi(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure)
    }
    private fun onSuccess(data: State<BaseResponse<Result>>) {
        State.Success(data.toData())
        comics.postValue(data)
    }

    private fun onFailure(message: Throwable) {
        State.Failure(message.message.toString())
    }

    override fun onClick(item: Result) {

     }
}