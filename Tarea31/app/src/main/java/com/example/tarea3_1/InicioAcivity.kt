package com.example.miprimeraapp

import android.os.Bundle
import com.example.miprimeraapp.databinding.ActivityInicioBinding

class InicioAcivity : PintorMenuActivity() {


    lateinit var bindingBarraApp : ActivityInicioBinding

    /**
     * Página de Inicio de la App.
     * Está vacía porque no encuentro la inspiración para un inicio
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBarraApp = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(bindingBarraApp.root)
        overridePendingTransition(0,0)
        allocateActivityTitle("Inicio")
    }
}