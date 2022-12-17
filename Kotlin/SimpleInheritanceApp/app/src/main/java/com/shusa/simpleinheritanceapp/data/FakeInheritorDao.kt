package com.shusa.simpleinheritanceapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shusa.simpleinheritanceapp.R

// Singleton Class
class FakeInheritorDao {
    private val inheritorList = mutableListOf<Inheritor>()
    private val inheritors = MutableLiveData<List<Inheritor>>()

    // Initialization of the Dao
    init {
        inheritors.value = inheritorList
        Log.d(GlobalContext.getCurrentContext().getString(R.string.log_initialized), javaClass.name)
    }

    // Member Methods
    fun addInheritor(inheritor: Inheritor) {
        inheritorList.add(inheritor)
        inheritors.value = inheritorList
    }

    fun getInheritors() = inheritors as LiveData<List<Inheritor>>
}