package com.shusa.simpleinheritanceapp.data

class Inheritor(_name: String?, _shares: Int?) {
    private var name: String? = _name
    private var shares: Int? = _shares
    private var inheritance: Double? = 0.0

    init {
        // Initialized
    }

    fun getName(): String = name as String
    fun getShares(): Int = shares as Int
    fun getInheritance(): Double = inheritance as Double

    fun setInheritance(vps: Double?) {
        inheritance = (vps!! * shares!!)
    }
}