package com.example.calculatorintent

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Receive extras (defaults set to 0.0)
        val num1 = intent.getDoubleExtra("num1", Double.NaN)
        val num2 = intent.getDoubleExtra("num2", Double.NaN)

        if (num1.isNaN() || num2.isNaN()) {
            tvResult.text = "Invalid input received."
        } else {
            val add = num1 + num2
            val sub = num1 - num2
            val mul = num1 * num2
            val divText = if (num2 != 0.0) (num1 / num2).toString() else "Cannot divide by zero"

            // Optional: format to avoid long decimals
            fun nice(n: Double): String {
                return if (n % 1.0 == 0.0) n.toInt().toString() else String.format("%.4f", n)
            }

            val sb = StringBuilder()
            sb.append("Addition: ${nice(add)}\n")
            sb.append("Subtraction: ${nice(sub)}\n")
            sb.append("Multiplication: ${nice(mul)}\n")
            sb.append("Division: $divText\n")

            tvResult.text = sb.toString()
        }

        btnBack.setOnClickListener { finish() }
    }
}
