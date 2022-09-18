package com.example.marvelapp.ui.adapter

import com.example.marvelapp.data.model.characters.Result
import com.example.marvelapp.ui.base.BaseInteractionListener

interface OnClickListener : BaseInteractionListener {
    fun onClick(item: Result)
}