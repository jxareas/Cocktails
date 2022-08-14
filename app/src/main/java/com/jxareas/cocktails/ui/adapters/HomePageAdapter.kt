package com.jxareas.cocktails.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jxareas.cocktails.R
import com.jxareas.cocktails.ui.favorites.FavoriteCocktailsFragment
import com.jxareas.cocktails.ui.search.SearchCocktailsFragment

class HomePageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val fragments: Set<Fragment> = setOf(
        SearchCocktailsFragment(),
        FavoriteCocktailsFragment()
    )
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    val titles: Set<Int>
        get() = setOf(R.string.search, R.string.favorites)

    val icons: Set<Int>
        get() = setOf(R.drawable.search_tab_selector, R.drawable.favorite_tab_selector)

    override fun getItemCount(): Int =
        fragments.size

    override fun createFragment(position: Int): Fragment =
        fragments.elementAt(position)
}
