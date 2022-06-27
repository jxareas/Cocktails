package com.jxareas.cocktails.ui.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jxareas.cocktails.R

class SearchCocktailsFragment : Fragment() {

    companion object {
        fun newInstance() = SearchCocktailsFragment()
    }

    private lateinit var viewModel: SearchCocktailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_cocktails, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchCocktailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
