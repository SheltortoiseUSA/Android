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
    private lateinit var netWorthET: EditText

    private var totalShares: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inheritance)

        nameET = findViewById(R.id.main_name_et)
        sharesET = findViewById(R.id.main_shares_et)
        addInheritorBtn = findViewById(R.id.main_add_inheritor_btn)
        netWorthET = findViewById(R.id.main_new_worth_et)

        initializeUi()
    }

    // Initialization ==============================================================================
    private fun initializeUi() {
        val factory = InjectorUtility.provideInheritorsViMFactory()
        val viewModel = ViewModelProvider(this, factory)[InheritorsViM::class.java]

        viewModel.getInheritors().observe(this, { inheritors ->
            inheritors.forEach { inheritor ->
                var netWorth = 0.0

                try {
                    netWorth = Integer.parseInt(netWorthET.text.toString()).toDouble()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, getString(R.string.toast_invalid_shares_input), Toast.LENGTH_SHORT).show()
                }

                // Get Value per Share
                val vps = (inheritor.getShares() / netWorth)
                inheritor.setInheritance(vps)

                // Set Values for Card
                val name = inheritor.getName()
                val shares = inheritor.getShares()
                val inheritance = inheritor.getInheritance()


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
                totalShares += shares

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