package com.example.miprimeraapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.miprimeraapp.databinding.ActivityCambioColorBinding

class CambioColorActivity : PintorMenuActivity() {

     lateinit var cambioColorBinding : ActivityCambioColorBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //Las primeras lineas sirven para superponer el layout completo,
        //con el vanView, la barra de la app y la página que queremos
        super.onCreate(savedInstanceState)
        cambioColorBinding = ActivityCambioColorBinding.inflate(layoutInflater)
        setContentView(cambioColorBinding.root)
        allocateActivityTitle("Cambio de Color")


        //Declaro e instancio los botones y el texto que escribirá el usuario
        val btnVerde : Button = findViewById(R.id.btnVerde)
        val btnRojo : Button = findViewById(R.id.btnRojo)
        val btnAzul : Button = findViewById(R.id.btnAzul)

        val txt : EditText = findViewById(R.id.txtModificarColor)



        //Establezco que cuando se pulse uno de los botones estos haran que cambie el color del texto escrito por el usuario
        btnAzul?.setOnClickListener {
            txt.setTextColor(Color.BLUE)
        }
        btnRojo?.setOnClickListener {
            txt.setTextColor(Color.RED)
        }
        btnVerde?.setOnClickListener {
            txt.setTextColor(Color.GREEN)
        }

    }
}