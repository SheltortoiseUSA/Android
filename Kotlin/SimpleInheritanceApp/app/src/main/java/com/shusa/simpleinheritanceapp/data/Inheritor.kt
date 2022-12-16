package com.shusa.simpleinheritanceapp.data

import android.util.Log
import com.shusa.simpleinheritanceapp.R

class Inheritor(_name: String?, _shares: Int?) {
    private var name: String? = _name
    private var shares: Int? = _shares
    private var inheritance: Double? = 0.0

    init {
        Log.d(GlobalContext.getCurrentContext().getString(R.string.log_initialized), javaClass.name)
    }

    fun getName(): String = name as String
    fun getShares(): Int = shares as Int
    fun getInheritance(): Double = inheritance as Double

    fun setInheritance(vps: Double?) {
        inheritance = (vps!! * shares!!)
    }
}