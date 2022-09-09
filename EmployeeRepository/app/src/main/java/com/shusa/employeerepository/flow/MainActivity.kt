package com.shusa.employeerepository.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.shusa.employeerepository.R
import com.shusa.employeerepository.data.EmployeeLibrary
import com.shusa.employeerepository.json.JsonUtility
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    // Tag for Logging
    private val classTag: String? = this::class.java.simpleName

    // Views for Global Access
    private lateinit var employeesRV: RecyclerView
    private lateinit var getEmployeesBtn: Button

    // Boolean to prevent multiple clicks of the button.
    private var isProcessing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Links Local View Objects to XML Views
        employeesRV = findViewById(R.id.main_employees_rv)
        getEmployeesBtn = findViewById(R.id.main_get_employees_btn)

        // Tethers Pull Request to Button Press
        getEmployeesBtn.setOnClickListener {
            if (!isProcessing) {
                isProcessing = true;
                httpsGetEmployees()
            }
        }
    }

    /**
     * Function to get the Employee JSON from the S3
     *
     * NOTE:
     *  - Stack Overflow: https://stackoverflow.com/questions/46177133/http-request-in-android-with-kotlin
     */
    fun httpsGetEmployees() {
        thread {
            // Resets the singleton object in preparation for the new json input.
            EmployeeLibrary.removeAllEmployees()

            val stringBuilder = StringBuilder()
            val url = URL("https://s3.amazonaws.com/sq-mobile-interview/employees.json")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"

                val request = ("\nSent 'GET' request to URL : $url; Response Code : $responseCode")
                Log.e(classTag, request)

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        stringBuilder.append(line)
                        Log.e(classTag, line);
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
        isProcessing = false
    }
}