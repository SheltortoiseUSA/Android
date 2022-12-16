package com.shusa.simpleinheritanceapp.data

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object GlobalContext {
    lateinit var context: Context

    fun updateContext(inputContext: Context) {
        context = inputContext
    }

    fun getCurrentContext() = context
}