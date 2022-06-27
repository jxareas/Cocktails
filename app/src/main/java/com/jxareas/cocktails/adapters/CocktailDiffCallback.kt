package com.jxareas.cocktails.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jxareas.cocktails.domain.model.Cocktail

object CocktailDiffCallback : DiffUtil.ItemCallback<Cocktail>() {
    override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
        oldItem.image == newItem.image
}
