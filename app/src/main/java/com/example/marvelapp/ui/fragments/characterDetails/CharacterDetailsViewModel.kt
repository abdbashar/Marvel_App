package com.example.marvelapp.ui.fragments.characterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvelapp.data.State
import com.example.marvelapp.data.model.BaseResponse
import com.example.marvelapp.data.model.characters.Result
import com.example.marvelapp.data.repository.ComicRepositoryImpl
import com.example.marvelapp.ui.base.BaseViewModel
import com.example.marvelapp.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterDetailsViewModel : BaseViewModel() {

    val characterDetails = MutableLiveData<State<BaseResponse<Result>>>()
    private val _isButtonClicked = MutableLiveData(Event(false))
    val isButtonClicked: LiveData<Event<Boolean>>
        get() = _isButtonClicked

    private val _repository = ComicRepositoryImpl()

    fun getCharacter(id: Int) {
        characterDetails.postValue(State.Loading)
        _repository.getCharacterByIdApi(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure)
    }
    private fun onSuccess(data: State<BaseResponse<Result>>) {
        State.Success(data.toData())
        characterDetails.postValue(data)
    }

    private fun onFailure(message: Throwable) {
        State.Failure(message.message.toString())
    }

     fun onClick(){
         _isButtonClicked.postValue(Event(true))
     }

}