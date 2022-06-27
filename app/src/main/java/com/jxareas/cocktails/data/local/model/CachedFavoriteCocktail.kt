package com.jxareas.cocktails.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorites"
)
data class CachedFavoriteCocktail(
    @ColumnInfo(name = "image")
    val image: String = "",
    val name: String = "",
    val description: String = "",
    @ColumnInfo(name = "alcohol")
    val hasAlcohol: String = "non_alcoholic",
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cocktailId")
    val cocktailId: Int = 0
) : CachedEntity
