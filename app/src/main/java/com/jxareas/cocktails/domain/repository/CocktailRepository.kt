package com.jxareas.cocktails.domain.repository

import com.jxareas.cocktails.data.local.model.CachedCocktail
import com.jxareas.cocktails.domain.model.Cocktail
import com.jxareas.cocktails.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CocktailRepository {
    suspend fun getCocktailByName(name : String) : Flow<Resource<List<Cocktail>>>
    suspend fun saveFavoriteCocktail(cocktail : Cocktail)
    suspend fun isFavoriteCocktail(cocktail : Cocktail) : Boolean
    suspend fun getCachedCocktails(name : String) : Resource<List<Cocktail>>
    suspend fun storeCocktail(cocktail : CachedCocktail)
    suspend fun getFavoriteCocktails() : Flow<List<Cocktail>>
    suspend fun deleteFavoriteCocktail(cocktail : Cocktail)
}
