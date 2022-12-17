package com.shusa.simpleinheritanceapp.ui

import androidx.lifecycle.ViewModel
import com.shusa.simpleinheritanceapp.data.Inheritor
import com.shusa.simpleinheritanceapp.data.InheritorRepo

class InheritorViM(private val inheritorRepo: InheritorRepo) : ViewModel() {

    fun getInheritors() = inheritorRepo.getInheritors()

    fun addInheritor(inheritor: Inheritor) = inheritorRepo.addInheritor(inheritor)
}