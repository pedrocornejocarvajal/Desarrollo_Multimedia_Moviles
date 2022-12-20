package com.example.miprimeraapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.core.content.getSystemService
import com.example.miprimeraapp.databinding.ActivityCheckBoxesBinding
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.color.MaterialColors
import com.google.android.material.tabs.TabLayout.Mode
import com.google.android.material.theme.overlay.MaterialThemeOverlay

class CheckBoxesActivity : PintorMenuActivity() {


    lateinit var activityAgrandarTextoBinding: ActivityCheckBoxesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityAgrandarTextoBinding = ActivityCheckBoxesBinding.inflate(layoutInflater)
        setContentView(activityAgrandarTextoBinding.root)
        allocateActivityTitle("Diversos")


        //Declaro e instancio el boton de reinicio, los radio y el texto que escribirá el usuario
        val texto: EditText = findViewById(R.id.txtModificar)
        val btnAgrandar: MaterialCheckBox = findViewById(R.id.btnLetraGigante)
        val btnDisminuir: MaterialCheckBox = findViewById(R.id.btnLetraMinuscula)
        val btnBold: MaterialCheckBox = findViewById(R.id.btnNegrita)
        val btnRojo: MaterialCheckBox = findViewById(R.id.btnColorRojo)
        val btnReiniciar: Button = findViewById(R.id.btnReiniciar)

        //Establezco que si los radio no estan seleccionados estos se seleccionen y
        btnAgrandar?.setOnClickListener {

            if (btnDisminuir.isChecked) {
                btnDisminuir.isChecked = false
            }
                btnAgrandar.isChecked = true
                texto.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100F)


        }
        btnDisminuir?.setOnClickListener {
            if(btnAgrandar.isChecked)
                btnAgrandar.isChecked = false

                btnDisminuir.isChecked = true
                texto.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10F)

        }
        btnRojo?.setOnClickListener {

                btnRojo.isChecked = true
                texto.setTextColor(Color.RED)

        }



        btnBold?.setOnClickListener {

                btnBold.isChecked = true
                texto.setTypeface(null, Typeface.BOLD)

        }

        //Boton que se encarga de reiniciar el texto ya que no entiendo como deseleccionar un radio
        btnReiniciar?.setOnClickListener {
            btnBold.isChecked = false
            btnRojo.isChecked = false
            btnDisminuir.isChecked = false
            btnAgrandar.isChecked = false
            texto.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
            texto.setTextColor(Color.BLACK)
            texto.setTypeface(null, Typeface.NORMAL)
        }


    }
}