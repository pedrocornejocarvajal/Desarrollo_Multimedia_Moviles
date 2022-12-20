package com.example.examenpedrojesus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class TercerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tercera_vista)

        findViewById<Button>(R.id.botonSumarCafe).setOnClickListener { onClickButtonSumarCafe() }
        findViewById<Button>(R.id.botonRestarCafe).setOnClickListener { onClickButtonSumarCafe() }


    }

    @SuppressLint("SetTextI18n")
     fun onClickButtonSumarCafe() {

        val editText: EditText =findViewById(R.id.cantidadCafe)
        editText.setText(Integer.parseInt(editText.text.toString())+1)

    }

     fun onClickButtonRestarCafe() {
         val editText: EditText = findViewById(R.id.cantidadCafe)
         editText.setText(Integer.parseInt(editText.text.toString())+1)
    }

    fun onClickButtonSumarInfusion() {

        val editText: EditText =findViewById(R.id.cantidadInfusion)
        editText.setText(Integer.parseInt(editText.text.toString())+1)

    }

    fun onClickButtonRestarInfusion() {
        val editText: EditText = findViewById(R.id.cantidadInfusion)
        editText.setText(Integer.parseInt(editText.text.toString())+1)
    }
    fun onClickButtonSumarTostada() {

        val editText: EditText =findViewById(R.id.cantidadTostada)
        editText.setText(Integer.parseInt(editText.text.toString())+1)

    }

    fun onClickButtonRestarTostada() {
        val editText: EditText = findViewById(R.id.cantidadTostada)
        editText.setText(Integer.parseInt(editText.text.toString())+1)
    }

    fun onClickButtonSumarCroissant() {

        val editText: EditText =findViewById(R.id.cantidadCroissant)
        editText.setText(Integer.parseInt(editText.text.toString())+1)

    }

    fun onClickButtonRestarCroissant() {
        val editText: EditText = findViewById(R.id.cantidadCroissant)
        editText.setText(Integer.parseInt(editText.text.toString())+1)
    }
}