package com.jxareas.cocktails.di

import com.jxareas.cocktails.utils.DefaultDispatchers
import com.jxareas.cocktails.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
   fun provideDispatchers(): DispatcherProvider = DefaultDispatchers

}
