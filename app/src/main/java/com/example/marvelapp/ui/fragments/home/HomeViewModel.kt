package com.example.marvelapp.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.BaseResponse
import com.example.marvelapp.data.model.characters.Result
import com.example.marvelapp.data.repository.ComicRepositoryImpl
import com.example.marvelapp.ui.adapter.OnClickListener
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel(), OnClickListener {

    val characters = MutableLiveData<State<BaseResponse<Result>>>()

    private val _itemId = MutableLiveData<Event<Int>>()
          val itemId: LiveData<Event<Int>>
        get() = _itemId

    private val _repository = ComicRepositoryImpl()

    init {
         getCharacters()
    }

    private fun getCharacters() {
        characters.postValue(State.Loading)
        _repository.getCharactersApi().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure)
    }

    private fun onSuccess(data: State<BaseResponse<Result>>) {
        State.Success(data.toData())
        characters.postValue(data)
    }

    private fun onFailure(message: Throwable) {
         characters.postValue(State.Failure(message.message.toString()))
    }

    override fun onClick(item: Result) {
         _itemId.postValue(Event(item.id!!))
    }
}