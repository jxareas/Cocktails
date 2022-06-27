package com.jxareas.cocktails.ui.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jxareas.cocktails.R

class FavoriteCocktailsFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteCocktailsFragment()
    }

    private lateinit var viewModel: FavoriteCocktailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_cocktails, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteCocktailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
