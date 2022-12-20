package com.example.u3_ejercicio1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), ComunicadorInterfaces {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    override fun onClickButtonSumar() {

        val textView:TextView=findViewById(R.id.resultado)

        val resultado =(Integer.parseInt(textView.text.toString())+1)


        if (resultado==10){
                AlertDialog.Builder(this)
                    .setTitle("Estas aburrido no?")
                    .setMessage("Quieres reiniciar el contador?")
                    .setPositiveButton("Yes")  { dialog, which ->
                        textView.setText("0");
                    }.setNegativeButton("NO"){dialog, which->
                        textView.setText(resultado.toString())
                    }
                    .create()
                    .show()
            }else {
                textView.setText(resultado.toString())
            }

        }

    override fun onClickButtonRestar() {
        val textView:TextView=findViewById(R.id.resultado)
        textView.text = (Integer.parseInt(textView.text.toString())-1).toString()
    }


}