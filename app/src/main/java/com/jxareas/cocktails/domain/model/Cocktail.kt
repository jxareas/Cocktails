package com.jxareas.cocktails.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    val id : Int,
    val name : String,
    val description : String,
    val image : String,
    val hasAlcohol : String
) : Parcelable, DomainEntity
