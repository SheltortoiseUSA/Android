package com.shusa.simpleinheritanceapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// Singleton Class
class FakeInheritorDao {
    private val inheritorList = mutableListOf<Inheritor>()
    private val inheritors = MutableLiveData<List<Inheritor>>()

    // Initialization of the Dao
    init {
        inheritors.value = inheritorList
    }

    // Member Methods
    fun addInheritor(inheritor: Inheritor) {
        inheritorList.add(inheritor)
        inheritors.value = inheritorList
    }

    fun getInheritors() = inheritors as LiveData<List<Inheritor>>
}