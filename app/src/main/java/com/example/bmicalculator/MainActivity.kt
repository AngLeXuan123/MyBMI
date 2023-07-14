package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val buttonCalculate: Button = findViewById(R.id.ButtonCalculate)
        val buttonReset: Button = findViewById(R.id.ButtonReset)

        buttonCalculate.setOnClickListener(){
            if(editTextWeight.text.isBlank()){
                editTextWeight.setError(getString(R.string.error_input))
                return@setOnClickListener
            }
            if(editTextHeight.text.isBlank()){
                editTextHeight.setError(getString(R.string.error_input))
                return@setOnClickListener
            }
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat()
            val bmi = weight/ (height/100).pow(2)

            if(bmi < 18.5){
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)//BMI : 18.45
                textViewStatus.text = String.format("%s : %s", getString(R.string.status), getString(R.string.under))
                imageViewBMI.setImageResource(R.drawable.under)
            }else if(bmi > 18.5 || bmi < 24.9){
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                textViewStatus.text = String.format("%s : %s", getString(R.string.status), getString(R.string.normal))
                imageViewBMI.setImageResource(R.drawable.normal)
            }else if(bmi > 25){
                textViewBMI.text = String.format("%s : %.2f", getString(R.string.bmi), bmi)
                textViewStatus.text = String.format("%s : %s", getString(R.string.status), getString(R.string.over))
                imageViewBMI.setImageResource(R.drawable.over)
            }
        }
        buttonReset.setOnClickListener(){
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            textViewBMI.text = getString(R.string.bmi)
            textViewStatus.text = getString(R.string.status)
        }
    }
}