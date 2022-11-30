package com.example.miprimeraapp

import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.EditText
import com.example.miprimeraapp.databinding.ActivityAlinearTextBinding
import com.example.miprimeraapp.databinding.ActivitySumaBinding
import java.awt.font.TextAttribute
import java.time.format.TextStyle
import kotlin.math.max

class AlinearText : PintorMenuActivity() {

    lateinit var activityAlinearTextoBinding : ActivityAlinearTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        //Pinto la barra de la app, el navView y el layout correspondiente a esta clase(AlinearText)
        activityAlinearTextoBinding = ActivityAlinearTextBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(activityAlinearTextoBinding.root)
        overridePendingTransition(0,0)
        allocateActivityTitle("Alinear Texto")


        //Declaro e instancio los botones y el texto que escribirá el usuario
        val btnIzd : Button = findViewById(R.id.btnAlinearIzquierda)
        val btnDcha : Button = findViewById(R.id.btnAlinearDerecha)
        val txInput : EditText = findViewById(R.id.txtInputAlign)





        //Establezco que cuando se clique el boton izquierda, el texto se alineará a la izquierda
        btnIzd?.setOnClickListener {
            txInput.textAlignment = TEXT_ALIGNMENT_TEXT_START
        }
        //Establezco que cuando se clique el boton derecha, el texto se alineará a la derecha
        btnDcha?.setOnClickListener {
            txInput.textAlignment = TEXT_ALIGNMENT_TEXT_END
        }



    }
}