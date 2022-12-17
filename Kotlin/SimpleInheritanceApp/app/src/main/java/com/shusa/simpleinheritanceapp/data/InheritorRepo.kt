package com.shusa.simpleinheritanceapp.data

class InheritorRepo private constructor(private val inheritorDao: FakeInheritorDao) {

    companion object {
        @Volatile
        private var instance: InheritorRepo? = null

        fun getInstance(inheritorListDao: FakeInheritorDao) =
            instance ?: synchronized(this) {
                instance ?: InheritorRepo(inheritorListDao).also { instance = it }
            }
    }

    fun addInheritor(inheritor: Inheritor) {
        inheritorDao.addInheritor(inheritor)
    }

    fun getInheritors() = inheritorDao.getInheritors()
}