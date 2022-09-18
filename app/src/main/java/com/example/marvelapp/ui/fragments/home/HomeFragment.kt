package com.example.marvelapp.ui.fragments.home

import androidx.navigation.fragment.findNavController
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentHomeBinding
import com.example.marvelapp.ui.adapter.HomeAdapter
import com.example.marvelapp.ui.base.BaseFragment
import com.example.marvelapp.util.EventObserve

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override fun setup() {
        binding.characterList.adapter = HomeAdapter(mutableListOf(),viewModel)
        navigateToCharacterDetails()
     }

    private fun navigateToCharacterDetails() {
    viewModel.itemId.observe(this,EventObserve{
          findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCharacterDetailsFragment(it))
    })
    }

}