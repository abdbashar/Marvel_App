package com.example.marvelapp.ui.adapter

import com.example.marvelapp.R
import com.example.marvelapp.data.model.characters.Result
import com.example.marvelapp.ui.base.BaseAdapter

class ComicAdapter(
    private val comicData: List<Result>,
    private val listener: OnClickListener
) : BaseAdapter<Result>(comicData,listener) {
    override val layoutID: Int
        get() =  R.layout.item_comic

}