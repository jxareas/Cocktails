package com.jxareas.cocktails.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jxareas.cocktails.data.local.model.CachedCocktail
import com.jxareas.cocktails.data.local.model.CachedFavoriteCocktail

@Database(
    entities = [CachedCocktail::class, CachedFavoriteCocktail::class],
    version = CocktailsDatabase.DATABASE_VERSION,
    exportSchema = false
)
abstract class CocktailsDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "cocktails.db"
        const val DATABASE_VERSION = 1
    }

}
