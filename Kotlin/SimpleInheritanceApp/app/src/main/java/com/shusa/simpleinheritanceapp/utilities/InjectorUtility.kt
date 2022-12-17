package com.shusa.simpleinheritanceapp.utilities

import com.shusa.simpleinheritanceapp.data.FakeDatabase
import com.shusa.simpleinheritanceapp.data.InheritorRepo
import com.shusa.simpleinheritanceapp.ui.InheritorViMFactory

object InjectorUtility {

    fun provideInheritorsViMFactory() : InheritorViMFactory {
        val inheritorRepo = InheritorRepo.getInstance(FakeDatabase.getInstance().inheritorDao)
        return InheritorViMFactory(inheritorRepo)
    }
}