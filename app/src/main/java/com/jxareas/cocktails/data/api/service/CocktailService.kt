package com.jxareas.cocktails.data.api.service

import com.jxareas.cocktails.data.api.constants.ApiConstants
import com.jxareas.cocktails.data.api.dto.response.GetCockailsByNameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {

    @GET(ApiConstants.SEARCH_ENDPOINT)
    suspend fun getCocktailsByName(@Query(value = "s") name: String): GetCockailsByNameResponse

}
