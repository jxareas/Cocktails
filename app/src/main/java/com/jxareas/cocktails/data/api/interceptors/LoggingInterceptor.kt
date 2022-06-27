package com.jxareas.cocktails.data.api.interceptors

import com.jxareas.logging.Logger
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptor : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Logger.i(message)
    }
}
