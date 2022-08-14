package com.jxareas.cocktails.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jxareas.cocktails.ui.adapters.CocktailsCardAdapter
import com.jxareas.cocktails.databinding.FragmentSearchCocktailsBinding
import com.jxareas.cocktails.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchCocktailsFragment : Fragment() {
    private var _binding: FragmentSearchCocktailsBinding? = null
    private val binding: FragmentSearchCocktailsBinding
        get() = _binding!!


    private val viewModel: SearchCocktailsViewModel by viewModels()
    private val cocktailsAdapter = CocktailsCardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchCocktailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.cocktails.observe(viewLifecycleOwner) { cocktails ->
            cocktails?.let { listOfCocktails ->
                when (listOfCocktails) {
                    is Resource.Success -> {
                        cocktailsAdapter.submitList(listOfCocktails.data)
                    }
                    is Resource.Error -> {}
                    else -> {}
                }
            }
        }
    }

    private fun setupRecyclerView() = binding.recyclerViewCocktails.run {
        adapter = cocktailsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
