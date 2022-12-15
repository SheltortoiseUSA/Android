package com.shusa.simpleinheritanceapp.utilities

import com.shusa.simpleinheritanceapp.data.FakeDatabase
import com.shusa.simpleinheritanceapp.data.InheritorRepo
import com.shusa.simpleinheritanceapp.ui.InheritorsViMFactory

object InjectorUtility {

    fun provideInheritorsViMFactory() : InheritorsViMFactory {
        val inheritorRepo = InheritorRepo.getInstance(FakeDatabase.getInstance().inheritorDao)
        return InheritorsViMFactory(inheritorRepo)
    }
}