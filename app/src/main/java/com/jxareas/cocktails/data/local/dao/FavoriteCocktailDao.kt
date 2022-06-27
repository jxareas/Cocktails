package com.jxareas.cocktails.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jxareas.cocktails.data.local.model.CachedFavoriteCocktail

@Dao
interface FavoriteCocktailDao : BaseDao<CachedFavoriteCocktail> {

    @Query("SELECT * FROM favorites")
    fun getAll(): List<CachedFavoriteCocktail>

    @Query("SELECT * FROM favorites WHERE cocktailId = :id")
    fun getById(id: String): CachedFavoriteCocktail?

}
