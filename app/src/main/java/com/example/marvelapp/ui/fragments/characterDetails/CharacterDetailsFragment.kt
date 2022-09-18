package com.example.marvelapp.ui.fragments.characterDetails


import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterDetailsBinding
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.util.EventObserve

class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>(){
    private val arguments: CharacterDetailsFragmentArgs by navArgs()
    override val layoutIdFragment: Int = R.layout.fragment_character_details
    override val viewModelClass: Class<CharacterDetailsViewModel> = CharacterDetailsViewModel::class.java

    override fun setup() {
        viewModel.getCharacter(arguments.characterId)
        navigateToComicsFragment()
      }

    private fun navigateToComicsFragment() {
        viewModel.isButtonClicked.observe(this,EventObserve{
            if (it){
                findNavController().navigate(CharacterDetailsFragmentDirections
                    .actionComicDetailsFragmentToCharacterComicsFragment(arguments.characterId))
                }
        })
    }
}