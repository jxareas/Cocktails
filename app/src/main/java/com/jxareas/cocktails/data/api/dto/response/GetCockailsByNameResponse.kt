package com.jxareas.cocktails.data.api.dto.response

import com.jxareas.cocktails.data.api.dto.model.ApiCocktail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GetCockailsByNameResponse {
    @SerialName("drinks")
    val cocktailList: List<ApiCocktail> = listOf()
}
