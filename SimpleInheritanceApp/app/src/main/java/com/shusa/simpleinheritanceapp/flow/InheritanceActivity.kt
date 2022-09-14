package com.shusa.simpleinheritanceapp.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.shusa.simpleinheritanceapp.R
import com.shusa.simpleinheritanceapp.data.Inheritor
import com.shusa.simpleinheritanceapp.ui.InheritorsViM
import com.shusa.simpleinheritanceapp.utilities.InjectorUtility
import java.lang.Exception

class InheritanceActivity : AppCompatActivity() {
    private lateinit var nameET: EditText
    private lateinit var sharesET: EditText
    private lateinit var addInheritorBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameET = findViewById(R.id.main_name_et)
        sharesET = findViewById(R.id.main_shares_et)
        addInheritorBtn = findViewById(R.id.main_add_inheritor_btn)

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

        addInheritorBtn.setOnClickListener {
            if (nameET.text.isNotEmpty() && sharesET.text.isNotEmpty()) {
                val name = nameET.text.toString()
                var shares = 0

                try {
                    shares = Integer.parseInt(sharesET.text.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, getString(R.string.toast_invalid_shares_input), Toast.LENGTH_SHORT).show()
                }

                val inheritor = Inheritor(name, shares)
                viewModel.addInheritor(inheritor)

                // Reset Inputs
                nameET.setText("")
                sharesET.setText("")
            } else {
                Toast.makeText(this, getString(R.string.toast_empty_input_fields), Toast.LENGTH_SHORT).show()
            }
        }
    }
}