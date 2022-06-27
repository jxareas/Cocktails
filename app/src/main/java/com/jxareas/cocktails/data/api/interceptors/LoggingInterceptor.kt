package com.jxareas.cocktails.data.api.interceptors

import com.jxareas.logging.Logger
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggingInterceptor @Inject constructor() : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        Logger.i(message)
    }
}
