package com.shusa.mvvmquoteapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// Singleton Class
class FakeQuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    // Initialization of the Dao
    init {
        quotes.value = quoteList
    }

    // Member Methods
    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}