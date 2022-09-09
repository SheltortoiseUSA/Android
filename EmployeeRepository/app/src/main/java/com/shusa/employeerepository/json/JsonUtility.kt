package com.shusa.employeerepository.json

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shusa.employeerepository.R
import com.shusa.employeerepository.data.Employee
import com.shusa.employeerepository.data.EmployeeLibrary
import com.shusa.employeerepository.data.GlobalContext

// Copied from my Github and slightly altered.
object JsonUtility {

    // Initialization of this Singleton Object
    init {
        Log.d(GlobalContext.getCurrentContext().getString(R.string.log_initialized), javaClass.name)
    }

    // Unpacks any JSON Payload from File.
    fun unpackData(jsonString: String) {
        packEmployeeLibrary(jsonString)
    }

    // Packs all the employees from file into singleton memory.
    private fun packEmployeeLibrary(inputJson: String?) {
        // Employee data members listed in order of specs.
        var tempUUID: String?
        var tempFullName: String?
        var tempPhoneNumber: String?
        var tempEmailAddress: String?
        var tempBiography: String?
        var tempPhotoUrlSmall: String?
        var tempPhotoUrlLarge: String?
        var tempTeam: String?
        var tempEmployeeType: String?

        val gson = Gson()
        val listEmployees = object : TypeToken<List<Employee>>() {}.type
        val employeeList: List<Employee> = gson.fromJson(inputJson, listEmployees)

        employeeList.forEachIndexed { idx, employee ->
            tempUUID = employee.getUUID()
            tempFullName = employee.getFullName()
            tempPhoneNumber = employee.getPhoneNumber()
            tempEmailAddress = employee.getEmailAddress()
            tempBiography = employee.getBiography()
            tempPhotoUrlSmall = employee.getPhotoUrlSmall()
            tempPhotoUrlLarge = employee.getPhotoUrlLarge()
            tempTeam = employee.getTeam()
            tempEmployeeType = employee.getEmployeeType()

            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempUUID")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempFullName")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempPhoneNumber")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempEmailAddress")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempBiography")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempPhotoUrlSmall")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempPhotoUrlLarge")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempTeam")
            Log.d(GlobalContext.getCurrentContext().getString(R.string.log_data), " Item $idx:\n$tempEmployeeType")

            EmployeeLibrary.addEmployee(employee)
        }
    }
}