package com.jxareas.cocktails.data.api.dto.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiCocktail(
    @SerialName("idDrink")
    val id: String = "",
    @SerialName("strDrinkThumb")
    val image: String = "",
    @SerialName("strDrink")
    val name: String = "",
    @SerialName("strInstructions")
    val description: String = "",
    @SerialName("strAlcoholic")
    val hasAlcohol: String = "Non_Alcoholic"
) : ApiEntity
