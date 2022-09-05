package com.shusa.employeerepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val CLASS_TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        httpsGet()
    }

    // Stack Overflow: https://stackoverflow.com/questions/46177133/http-request-in-android-with-kotlin
    fun httpsGet() {
        thread {
            val url = URL("https://s3.amazonaws.com/sq-mobile-interview/employees.json")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"

                val request = ("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                Log.e(CLASS_TAG, request)

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        Log.e(CLASS_TAG, line);
                    }
                }
            }
        }
    }
}