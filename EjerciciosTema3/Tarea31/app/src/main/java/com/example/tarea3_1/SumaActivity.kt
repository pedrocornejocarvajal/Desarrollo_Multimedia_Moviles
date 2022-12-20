package com.example.miprimeraapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.miprimeraapp.databinding.ActivitySumaBinding

class SumaActivity : PintorMenuActivity() {


    lateinit var activitySumaBinding : ActivitySumaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Las primeras lineas sirven para superponer el layout completo,
        //con el vanView, la barra de la app y la página que queremos
        activitySumaBinding = ActivitySumaBinding.inflate(layoutInflater)
        setContentView(activitySumaBinding.root)
        overridePendingTransition(0,0)
        allocateActivityTitle("Suma")



        //Declaro e instancio el botón que llamará al método suma()
        //el textView donde se mostrará dicho resultado
        val btn : Button = findViewById(R.id.btnSuma)
        val resultado : TextView = findViewById(R.id.txtResultado)

        btn?.setOnClickListener {
            sumar()
        }
    }


    /**
     * Funcion que se encarga de recoger los dos EditText que se en cuentran en el layout
     * parsea el string a Double y realiza la suma, después lo muestra en el TextView "resultado"
     */
    fun sumar() {
        //Recojo los dos números introducidos por teclado por el usuario
        val num1 = findViewById<EditText>(R.id.num_suma_1)
        val num2 : EditText = findViewById(R.id.num_suma_2)

        //Genero un valor que será la suma del parseo a Double de cada uno de los dos Strings introducidos
        //en los editText
        val resultado : Double = (num1.text.toString().toDouble()) + (num2.text.toString().toDouble())
        val textView = findViewById<TextView>(R.id.txtResultado)

        //Muestro en el textView el resultado en forma de String
        textView.text = "Resultado: $resultado"
    }

}