package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import com.example.miprimeraapp.databinding.ActivityCambiarSizeLetraBinding

class CambiarSizeLetraActivity : PintorMenuActivity() {

    lateinit var acsl: ActivityCambiarSizeLetraBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Las primeras lineas sirven para superponer el layout completo,
        //con el vanView, la barra de la app y la página que queremos
        acsl = ActivityCambiarSizeLetraBinding.inflate(layoutInflater)
        setContentView(acsl.root)
        overridePendingTransition(0,0)
        allocateActivityTitle("Modificar Tamaño de letra")



        val btnMas : Button = findViewById(R.id.btnMas)
        val btnMenos : Button = findViewById(R.id.btnMenos)
        val txtCambiarSize : EditText = findViewById(R.id.txtModificarSize)

        //Variable para controlar el tamaño de la letra
        var size = txtCambiarSize.textSize


        //Llamamos al método onClick para que, si el tamaño de la letra es menos que 100
        //sume 1F y aumente el valor del textSize
        btnMas?.setOnClickListener {
            size += 1F
            if(size <= 100F){
                txtCambiarSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)

            }

        }
        //Llamamos al método onClick para que, si el tamaño de la letra es mayor que 0
        //reste 1F y disminuya el valor del textSize

        btnMenos?.setOnClickListener {
            size -= 1F
            if(size >= 2F){
                txtCambiarSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            }

        }
    }
}