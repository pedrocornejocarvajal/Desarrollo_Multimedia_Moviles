package com.example.miprimeraapp

import android.app.Notification
import android.content.Context
import android.media.AudioManager
import android.media.effect.Effect
import android.opengl.Visibility
import android.os.*
import android.provider.MediaStore.Audio.Media
import android.service.autofill.VisibilitySetterAction
import android.view.SoundEffectConstants
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import com.example.miprimeraapp.databinding.ActivitySuprimirVolumenBinding


class SuprimirVolumenActivity : PintorMenuActivity() {


    //Variable que contendrá los datos de audio
    private lateinit var audio: AudioManager
    lateinit var asvb: ActivitySuprimirVolumenBinding

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Las primeras lineas sirven para superponer el layout completo,
        //con el vanView, la barra de la app y la página que queremos
        asvb = ActivitySuprimirVolumenBinding.inflate(layoutInflater)
        setContentView(asvb.root)
        overridePendingTransition(0, 0)
        allocateActivityTitle("Suprimir Volumen")


        //Recogemos las Vistas necesarias de nuestro layout
        val btnUnmute: ImageButton = findViewById(R.id.imagenSubirVolumen)
        var btnMute: ImageButton = findViewById(R.id.imagenBajarVolumen)

        //Recogemos los permisos para acceder al audio del dispositivo
        audio = applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager


        //Al pulsar la imagen, esta se modificará y también muteará o desmuteará el volumen del dispositivo
        btnUnmute?.setOnClickListener {

            //Ajustamos el volumen a estado activo y hago que suene una alerta(No he podido saber porqué no suena)
            audio.adjustVolume(AudioManager.ADJUST_UNMUTE, 1)
            //Cambio la visibilidad de este boton a gone y la del boton de mute a visible
            btnUnmute.visibility = View.GONE
            btnMute.visibility = View.VISIBLE

        }
        btnMute?.setOnClickListener {

            //Ajustamos el volumen a estado mute
            audio.adjustVolume(AudioManager.ADJUST_MUTE,1)

            //Cambio la visibilidad de este boton a gone y la del boton de unmute a visible
            btnMute.visibility = View.GONE
            btnUnmute.visibility = View.VISIBLE

        }
    }
}