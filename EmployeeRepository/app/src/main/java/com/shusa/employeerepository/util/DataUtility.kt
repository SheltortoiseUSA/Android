package com.shusa.employeerepository.util

import android.util.Log
import com.shusa.employeerepository.R
import com.shusa.employeerepository.data.GlobalContext
import java.util.*

object DataUtility {

    // Initialization of this Singleton Object
    init {
        Log.d(GlobalContext.getCurrentContext().getString(R.string.log_initialized), javaClass.name)
    }

    // Simple utility function for capitalizing the first character of an input String.
    fun capitalizeFirstChar(inputString: String): String {
        return inputString.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}