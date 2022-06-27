package com.jxareas.cocktails.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jxareas.cocktails.databinding.FragmentCocktailDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CocktailDetailsFragment : Fragment() {
    private var _binding: FragmentCocktailDetailsBinding? = null
    private val binding: FragmentCocktailDetailsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
