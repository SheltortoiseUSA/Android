package com.shusa.employeerepository.data

import android.util.Log
import com.shusa.employeerepository.R

// Singleton Class for Ease-of-Access
object EmployeeLibrary {
    // Global Variable
    private var employees = mutableListOf<Employee>()

    // Initialization of this Singleton Object
    init {
        Log.d(GlobalContext.getCurrentContext().getString(R.string.log_initialized), javaClass.name)
    }

    // Adds an employee to the global list of employees.
    fun addEmployee(newEmployee: Employee) {
        employees.add(newEmployee)
    }

    // Returns the global list of employees.
    fun getEmployees() = employees

    // Removes All Employees
    fun removeAllEmployees() {
        employees.clear()
    }
}