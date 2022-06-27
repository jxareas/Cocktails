package com.jxareas.cocktails.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CachedCocktail(
    @ColumnInfo(name = "image")
    val image: String = "",
    val name: String = "",
    val description: String = "",
    @ColumnInfo(name = "alcohol")
    val hasAlcohol: String = "non_alcoholic",
    @PrimaryKey(autoGenerate = true)
    val cocktailId: Int = 0
) : CachedEntity
