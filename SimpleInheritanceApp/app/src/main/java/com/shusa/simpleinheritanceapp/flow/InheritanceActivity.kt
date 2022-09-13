package com.shusa.simpleinheritanceapp.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.shusa.simpleinheritanceapp.R
import com.shusa.simpleinheritanceapp.data.Inheritor
import com.shusa.simpleinheritanceapp.ui.InheritorsViM
import com.shusa.simpleinheritanceapp.utilities.InjectorUtility

class InheritanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    // Initialization ==============================================================================
    private fun initializeUi() {
        val factory = InjectorUtility.provideInheritorsViMFactory()
        val viewModel = ViewModelProvider(this, factory)[InheritorsViM::class.java]

        viewModel.getInheritors().observe(this, { inheritors ->
            inheritors.forEach { inheritor ->

            }
        })

        add_inheritor_btn.setOnClickListener {
            val inheritor = Inheritor(name_et.text.toString(), shares_tv.text.toString())
            viewModel.addInheritor(inheritor)

            name_et.setText("")
            shares_tv.setText("")
        }
    }
}