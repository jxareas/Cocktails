package com.jxareas.cocktails.adapters


import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jxareas.cocktails.databinding.ListItemCocktailCardBinding
import com.jxareas.cocktails.domain.model.Cocktail
import com.jxareas.cocktails.utils.bind
import com.jxareas.cocktails.utils.setImage

class CocktailsCardAdapter : ListAdapter<Cocktail, CocktailsCardAdapter.CocktailViewHolder>(
    AsyncDifferConfig.Builder(CocktailDiffCallback).build()
) {


    inner class CocktailViewHolder(private val binding: ListItemCocktailCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cocktail: Cocktail) = binding.run {
            textViewCocktailName.text = cocktail.name
            textViewCocktailDescription.text = cocktail.description
            imageViewCocktail.setImage(cocktail.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder =
        CocktailViewHolder(parent bind ListItemCocktailCardBinding::inflate)

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) =
        holder.bind(currentList[position])

}
