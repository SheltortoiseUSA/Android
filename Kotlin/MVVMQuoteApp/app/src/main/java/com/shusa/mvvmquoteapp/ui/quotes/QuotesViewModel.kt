package com.shusa.mvvmquoteapp.ui.quotes

import androidx.lifecycle.ViewModel
import com.shusa.mvvmquoteapp.data.Quote
import com.shusa.mvvmquoteapp.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}