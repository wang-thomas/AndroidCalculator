package com.example.calculatorapp
import fall2018.cis195.outputtext.OutputText

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    fun updateDisplay(content: String,  inputs: ArrayList<String>){
        if (inputs.size == 1 && inputs[0] == "0" && content != "."){
            inputs.clear()
        }

        inputs.add(content)
        val outputText = OutputText.createOutputText(inputs)
        firstLine.text = outputText

        val inputString = StringBuilder()
        for (letter in inputs){
            inputString.append(letter)
        }
        secondLine.text = inputString
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputs = arrayListOf<String>()
        val justDotted = arrayListOf<Boolean>()

        updateDisplay("0", inputs)

        button0.setOnClickListener {
            updateDisplay("0", inputs)
        }

        button1.setOnClickListener {
            updateDisplay("1", inputs)
        }

        button2.setOnClickListener {
            updateDisplay("2", inputs)
        }

        button3.setOnClickListener {
            updateDisplay("3", inputs)
        }

        button4.setOnClickListener {
            updateDisplay("4", inputs)
        }

        button5.setOnClickListener {
            updateDisplay("5", inputs)
        }

        button6.setOnClickListener {
            updateDisplay("6", inputs)
        }

        button7.setOnClickListener {
            updateDisplay("7", inputs)
        }

        button8.setOnClickListener {
            updateDisplay("8", inputs)
        }

        button9.setOnClickListener {
            updateDisplay("9", inputs)
        }

        buttonPoint.setOnClickListener {
            if (justDotted.size == 0 && inputs.last() != "+" &&
                    inputs.last() != "-" && inputs.last() != "."){
                updateDisplay(".", inputs)
                justDotted.add(true)
            }
        }

        buttonPlus.setOnClickListener {
            if (inputs.last() != "+" && inputs.last() != "-" && inputs.last() != "."){
                updateDisplay("+", inputs)
                justDotted.clear()
            }
        }

        buttonMinus.setOnClickListener {
            if (inputs.last() != "+" && inputs.last() != "-" && inputs.last() != "."){
                updateDisplay("-", inputs)
                justDotted.clear()
            }
        }

        buttonEquals.setOnClickListener {
            secondLine.text = firstLine.text
            inputs.clear()
            inputs.add(secondLine.text.toString())
            if (secondLine.text.toString().contains(".")){
                justDotted.add(true)
            }
        }

        buttonClear.setOnClickListener {
            inputs.clear()
            justDotted.clear()
            updateDisplay("0", inputs)
        }
    }
}
