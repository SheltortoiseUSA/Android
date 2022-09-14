package com.shusa.simpleinheritanceapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shusa.simpleinheritanceapp.data.InheritorRepo

class InheritorsViMFactory(private val inheritorRepo: InheritorRepo) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InheritorsViM(inheritorRepo) as T
    }
}