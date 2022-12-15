package com.shusa.mvvmquoteapp.utilities

import com.shusa.mvvmquoteapp.data.FakeDatabase
import com.shusa.mvvmquoteapp.data.QuoteRepository
import com.shusa.mvvmquoteapp.ui.quotes.QuotesViewModelFactory

object InjectorUtility {

    fun provideQuotesViewModelFactory() : QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}