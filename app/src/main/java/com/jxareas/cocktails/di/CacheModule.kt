package com.jxareas.cocktails.di

import android.content.Context
import androidx.room.Room
import com.jxareas.cocktails.data.local.dao.CocktailDao
import com.jxareas.cocktails.data.local.dao.FavoriteCocktailDao
import com.jxareas.cocktails.data.local.database.CocktailsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CocktailsDatabase =
        Room.databaseBuilder(
            context,
            CocktailsDatabase::class.java,
            CocktailsDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideCocktailsDao(database: CocktailsDatabase): CocktailDao =
        database.cocktailDao

    @Provides
    @Singleton
    fun provideFavoriteCocktailDao(database: CocktailsDatabase): FavoriteCocktailDao =
        database.favoriteCocktailDao

}
