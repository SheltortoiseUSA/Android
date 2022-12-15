package com.shusa.simpleinheritanceapp.data

class FakeDatabase private constructor() {
    var inheritorDao = FakeInheritorDao()
        private set

    // Singleton Instance
    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}