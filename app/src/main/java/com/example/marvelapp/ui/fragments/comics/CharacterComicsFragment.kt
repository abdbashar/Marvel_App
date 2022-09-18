package com.example.marvelapp.ui.fragments.comics

import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterComicsBinding
import com.example.marvelapp.ui.adapter.ComicAdapter
import com.example.marvelapp.ui.base.BaseFragment

class CharacterComicsFragment : BaseFragment<FragmentCharacterComicsBinding,CharacterComicsViewModel>(){

    private val arguments: CharacterComicsFragmentArgs by navArgs()
    override val layoutIdFragment = R.layout.fragment_character_comics
    override val viewModelClass = CharacterComicsViewModel::class.java

    override fun setup() {
        binding.comicList.adapter = ComicAdapter(mutableListOf(),viewModel)
        viewModel.getComics(arguments.characterId)
     }
}