package com.example.aplicationtesting.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.aplicationtesting.R
import com.example.aplicationtesting.databinding.ActivityCalculadorBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Locale

class CalculadorActivity : AppCompatActivity(), OnResolveListener {
    private lateinit var binding: ActivityCalculadorBinding
    private lateinit var calculatorUtils: CalculatorUtils
    private val operations = Operations

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorUtils = CalculatorUtils(operations, this)

        binding.tvOperation.run {
            addTextChangedListener { charSequence ->
                if (Operations.canReplaceOperator(charSequence.toString())) {
                    val newStr =
                        "${text.substring(0, text.length - 2)}${text.substring(text.length - 1)}"
                    text = newStr
                }
            }
        }
    }

    fun onClickButton(view: View) {
        val valueStr = (view as Button).text.toString()
        val operation = binding.tvOperation.text.toString()

        when (view.id) {
            R.id.btnDelete -> {
                binding.tvOperation.run {
                    if (text.length > 0) text = operation.substring(0, text.length - 1)
                }
            }

            R.id.btnClear -> {
                binding.tvOperation.text = ""
                binding.tvResult.text = ""
            }

            R.id.btnResolve -> calculatorUtils.checkOrResolve(operation, true)

            R.id.btnMulti,
            R.id.btnDiv,
            R.id.btnSum,
            R.id.btnSub -> {
                calculatorUtils.checkOrResolve(operation, false)

                calculatorUtils.addOperator(valueStr, operation) {
                    //TODO CUANDO SE TERMINE DE HACER TODO LO DE addOperator se hara esto
                    binding.tvOperation.append(valueStr)
                }
            }

            R.id.btnPoint -> calculatorUtils.addPoint(operation) {
                binding.tvOperation.append(valueStr)
            }

            else -> binding.tvOperation.append(valueStr)
        }
    }

    override fun onShowResult(result: Double, isFromResolve: Boolean) {
        binding.tvResult.text = String.format(Locale.ROOT, "%.2f", result)

        if (binding.tvResult.text.isNotEmpty() && !isFromResolve) {
            binding.tvOperation.text = binding.tvResult.text
        }
    }

    override fun onShowMessage(errorRes: Int) {
        Snackbar.make(binding.root, errorRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(binding.llTop)
            .show()
    }
}