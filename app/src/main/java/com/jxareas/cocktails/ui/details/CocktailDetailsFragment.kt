package com.jxareas.cocktails.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jxareas.cocktails.R

class CocktailDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = CocktailDetailsFragment()
    }

    private lateinit var viewModel: CocktailDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cocktail_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CocktailDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
