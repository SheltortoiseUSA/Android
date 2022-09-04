package com.shusa.mvvmquoteapp.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.shusa.mvvmquoteapp.R
import com.shusa.mvvmquoteapp.data.Quote
import com.shusa.mvvmquoteapp.utilities.InjectorUtility
import java.lang.StringBuilder
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtility.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, { quotes ->
            val stringBuilder = StringBuilder()

            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            quote_panel_tv.text = stringBuilder.toString()
        })

        add_quote_btn.setOnClickListener {
            val quote = Quote(quote_et.text.toString(), author_et.text.toString())
            viewModel.addQuote(quote)
            quote_et.setText("")
            author_et.setText("")
        }
    }
}