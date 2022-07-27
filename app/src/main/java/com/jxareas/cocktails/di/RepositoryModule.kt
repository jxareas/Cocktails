package com.jxareas.cocktails.di

import com.jxareas.cocktails.domain.repository.CocktailRepository
import com.jxareas.cocktails.data.repository.CocktailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindCocktailRepository(repository: CocktailRepositoryImpl): CocktailRepository

}
