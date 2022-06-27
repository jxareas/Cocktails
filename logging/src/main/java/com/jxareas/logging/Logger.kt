package com.jxareas.logging

import timber.log.Timber


object Logger {
    private val timberLogger by lazy {
        TimberLogging()
    }

    fun init() {
        Timber.plant(timberLogger)
    }

    fun d(message: String, t: Throwable? = null) = timberLogger.d(t, message)

    fun i(message: String, t: Throwable? = null) = timberLogger.i(t, message)

    fun e(t: Throwable? = null, message: String) = timberLogger.e(t, message)

    fun wtf(t: Throwable? = null, message: String) = timberLogger.wtf(t, message)
}
