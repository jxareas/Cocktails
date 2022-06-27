package com.jxareas.cocktails.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jxareas.cocktails.data.api.constants.ApiConstants
import com.jxareas.cocktails.data.api.interceptors.LoggingInterceptor
import com.jxareas.cocktails.data.api.service.CocktailService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json =
        Json {
            this.ignoreUnknownKeys = true
        }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor =
        HttpLoggingInterceptor(loggingInterceptor).apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(
        json: Json,
        okHttpClient: OkHttpClient
    ) =
        Retrofit
            .Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideCocktailService(retrofit: Retrofit): CocktailService =
        retrofit.create()

}
