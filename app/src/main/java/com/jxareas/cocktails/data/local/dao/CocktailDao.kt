package com.jxareas.cocktails.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jxareas.cocktails.data.local.model.CachedCocktail

@Dao
interface CocktailDao : BaseDao<CachedCocktail> {

    @Query("SELECT * FROM cocktails")
    fun getAll(): List<CachedCocktail>

    @Query("SELECT * FROM cocktails WHERE name LIKE '%' || :query || '%'")
    fun getByName(query: String): List<CachedCocktail>

    @Query("SELECT * FROM cocktails WHERE cocktailId = :id")
    fun getById(id: Int): CachedCocktail?

}
