package com.jxareas.cocktails.domain.repository

import com.jxareas.cocktails.data.api.service.CocktailService
import com.jxareas.cocktails.data.local.dao.CocktailDao
import com.jxareas.cocktails.data.local.dao.FavoriteCocktailDao
import com.jxareas.cocktails.data.local.model.CachedCocktail
import com.jxareas.cocktails.data.mappers.toCached
import com.jxareas.cocktails.data.mappers.toDomain
import com.jxareas.cocktails.data.repository.CocktailRepository
import com.jxareas.cocktails.domain.model.Cocktail
import com.jxareas.cocktails.utils.DispatcherProvider
import com.jxareas.cocktails.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailDao: CocktailDao,
    private val favoritesDao: FavoriteCocktailDao,
    private val cocktailService: CocktailService,
    private val dispatchers: DispatcherProvider
) : CocktailRepository {
    override suspend fun getCocktailByName(name: String): Flow<Resource<List<Cocktail>>> = flow {
        emit(getCachedCocktails(name))
        val response = cocktailService.getCocktailsByName(name)
        response.cocktailList.forEach { storeCocktail(it.toCached()) }
        emit(getCachedCocktails(name))
    }

    override suspend fun saveFavoriteCocktail(cocktail: Cocktail) =
        favoritesDao.insert(cocktail.toCached())


    override suspend fun isFavoriteCocktail(cocktail: Cocktail): Boolean =
        cocktailDao.getById(cocktail.id) != null

    override suspend fun getCachedCocktails(name: String): Resource<List<Cocktail>> =
        Resource.Success(cocktailDao.getByName(name).map { it.toDomain() })


    override suspend fun storeCocktail(cocktail: CachedCocktail) =
        cocktailDao.insert(cocktail)


    override suspend fun getFavoriteCocktails(): Flow<List<Cocktail>> = flow {
        emit(favoritesDao.getAll().map { it.toDomain() })
    }

    override suspend fun deleteFavoriteCocktail(cocktail: Cocktail) =
        favoritesDao.delete(cocktail.toCached())


}
