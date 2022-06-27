package com.jxareas.cocktails.data.mappers

import com.jxareas.cocktails.data.api.dto.model.ApiCocktail
import com.jxareas.cocktails.data.local.model.CachedCocktail
import com.jxareas.cocktails.data.local.model.CachedFavoriteCocktail
import com.jxareas.cocktails.domain.model.Cocktail

fun ApiCocktail.toDomain(): Cocktail =
    Cocktail(id.toInt(), name, description, image, hasAlcohol)

fun ApiCocktail.toCached(): CachedCocktail =
    CachedCocktail(image, name, description, hasAlcohol, id.toInt())

fun CachedCocktail.toDomain() : Cocktail =
    Cocktail(cocktailId, name, description, image, hasAlcohol)

fun CachedFavoriteCocktail.toDomain() : Cocktail =
    Cocktail(cocktailId, name, description, image, hasAlcohol)

fun Cocktail.toCached() : CachedFavoriteCocktail =
    CachedFavoriteCocktail(name, description, image, hasAlcohol)
