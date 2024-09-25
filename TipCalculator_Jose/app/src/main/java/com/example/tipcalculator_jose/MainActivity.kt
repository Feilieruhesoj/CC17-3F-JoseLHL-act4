package com.example.tipcalculator_jose

import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipcalculator_jose.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip ()}


    }

    private fun calculateTip() {
        val cost :Double = binding.serviceCost.text.toString().toDouble()
        val selectedID :Int = binding.tipOptions.checkedRadioButtonId
        val tipPercentage :Double = when(selectedID){
            R.id.option_twenty -> 0.2
            R.id.option_eighteen -> 0.18
            else -> 0.15
        }
        var tip :Double = cost*tipPercentage
        var roundedUp :Boolean = binding.roundUp.isChecked
        if (roundedUp){
            tip = ceil(tip)
        }
        val currencyTip :String = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, currencyTip)
    }
}