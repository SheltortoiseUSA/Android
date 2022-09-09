package com.shusa.employeerepository.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.shusa.employeerepository.R
import com.shusa.employeerepository.json.JsonUtility
import java.io.FileWriter
import java.io.PrintWriter
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val CLASS_TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        httpsGetEmployees()
    }

    /**
     * Function to get the Employee JSON from the S3
     *
     * NOTE:
     *  - Stack Overflow: https://stackoverflow.com/questions/46177133/http-request-in-android-with-kotlin
     */
    fun httpsGetEmployees() {
        thread {
            val stringBuilder = StringBuilder()
            val url = URL("https://s3.amazonaws.com/sq-mobile-interview/employees.json")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"

                val request = ("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                Log.e(CLASS_TAG, request)

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        stringBuilder.append(line)
                        Log.e(CLASS_TAG, line);
                    }
                }
            }
            storeEmployees(stringBuilder.toString())
        }
    }

    /**
     * Function to store the JSON from the S3, if it is a valid JSON
     *
     * NOTE:
     *  - https://www.techiedelight.com/write-json-to-a-file-in-kotlin/
     *  - https://www.techiedelight.com/create-a-directory-in-kotlin/
     *  - https://stackoverflow.com/questions/9372805/java-io-ioexception-read-only-file-system
     *  - https://stackoverflow.com/questions/1998400/data-directory-has-no-read-write-permission-in-android
     *  - https://stackoverflow.com/questions/45193941/how-to-read-and-write-txt-files-in-android-in-kotlin
     */
    fun storeEmployees(employees: String) {
        JsonUtility.unpackData(employees)
    }
}