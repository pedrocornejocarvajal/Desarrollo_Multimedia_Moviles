package com.example.a03_tarea3_3

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var secuencia = ArrayList<String>() //Secuncia en ronda actual
    var numero = 3    //número de luces encendidas
    var puntuacion = 0  //número de comprobaciones restantes

    //Objetos para los sonidos
    lateinit var acierto: MediaPlayer
    lateinit var fallo: MediaPlayer
    lateinit var next: MediaPlayer

    /**
     * Guarda el estado de las variables cuando el sistema destruye la Activity y más adelante la restaura.
     */
    override fun onSaveInstanceState(guardarEstado: Bundle) {
        super.onSaveInstanceState(guardarEstado)
        guardarEstado.putInt("numero", numero)
        guardarEstado.putInt("puntuacion", puntuacion)
    }

    /**
     * Restaura el estado de las variables cuando restaura la Activity
     */
    override fun onRestoreInstanceState(recEstado: Bundle) {
        super.onRestoreInstanceState(recEstado)
        numero = recEstado.getInt("numero")
        puntuacion= recEstado.getInt("restante")

       findViewById<TextView>(R.id.npuntuacion).setText(puntuacion.toString())
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.npuntuacion).setText(puntuacion.toString())

        //Botón play
        findViewById<Button>(R.id.botonPlay).setOnClickListener {
            numero=3
            puntuacion=0
            findViewById<TextView>(R.id.npuntuacion).setText(puntuacion.toString())
            mostrarSecuencia(numero)
        }

        //Botón azul
        findViewById<ImageButton>(R.id.botonCapi).setOnClickListener {
            comprobar(R.color.azul_encendido.toString())
        }

        //Botón verde
        findViewById<ImageButton>(R.id.botonHulk).setOnClickListener {
            comprobar(R.color.verde_encendido.toString())
        }

        //Botón amarillo
        findViewById<ImageButton>(R.id.botonThor).setOnClickListener {
            comprobar(R.color.amarillo_encendido.toString())
        }

        //Botón rojo
        findViewById<ImageButton>(R.id.botonIronman).setOnClickListener {
            comprobar(R.color.rojo_encendido.toString())
        }
    }

    /**
     * Muesta una secuencia de parpadeos
     * @numero: número de parpadeos que se van a realizar
     */
    private fun mostrarSecuencia(numero: Int) {

        var encendido = 0L

        for (i in 1..numero) {
            val random = Random().nextInt(4)
            encendido+=2500L
            when (random) {
                0 -> {
                    parpadeo(encendido,"azul",numero,i)
                    secuencia.add("azul")
                }
                1 -> {
                    parpadeo(encendido,"amarillo",numero,i)
                    secuencia.add("amarillo")
                }
                2 -> {
                    parpadeo(encendido,"verde",numero,i)
                    secuencia.add("verde")
                }
                3 -> {
                    parpadeo(encendido,"rojo",numero,i)
                    secuencia.add("rojo")
                }
            }
        }
    }

    /**
     * Realiza el parpadeo del botón @color
     * @encendido: Milisegundos de la secuenda a los que se va a encender la luz
     * @color: Color que se va a encender
     * @maximo: número de luces totales que se van a encender
     * @actual: número de luz actual que se va a encender respecto a @maximo de luces que se encienden
     */
    private fun parpadeo(encendido: Long, color: String,maximo: Int,actual: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(encendido)
            when (color) {
                "azul" -> {
                    findViewById<ImageButton>(R.id.botonCapi).setBackgroundColor(Color.alpha(R.color.azul_encendido))
                    delay(1000L)
                    findViewById<ImageButton>(R.id.botonCapi).setBackgroundColor(Color.alpha(R.color.azul_apagado))
                }
                "amarillo" -> {
                    findViewById<ImageButton>(R.id.botonThor).setBackgroundColor(Color.alpha(R.color.amarillo_encendido))
                    delay(1000L)
                    findViewById<ImageButton>(R.id.botonThor).setBackgroundColor(Color.alpha(R.color.amarillo_apagado))
                }
                "verde" -> {
                    findViewById<ImageButton>(R.id.botonHulk).setBackgroundColor(Color.alpha(R.color.verde_encendido))
                    delay(1000L)
                    findViewById<ImageButton>(R.id.botonHulk).setBackgroundColor(Color.alpha(R.color.verde_apagado))
                }
                "rojo" -> {
                    findViewById<ImageButton>(R.id.botonIronman).setBackgroundColor(Color.alpha(R.color.rojo_encendido))
                    delay(1000L)
                    findViewById<ImageButton>(R.id.botonIronman).setBackgroundColor(Color.alpha(R.color.rojo_apagado))
                }
            }
        }
    }

    /**
     * Comprueba si el usuario, a la hora de pulsar un botón, ha acertado con la siguiente luz de la secuencia.
     * Realiza una serie de operaciones según haya acertado, haya fallado o no queden comprobaciones restantes.
     * @color: Botón que pulsó el usuario
     */
    private fun comprobar(color: String){
        if(secuencia.isEmpty()){
            numero=3
            puntuacion=0
            fallo = MediaPlayer.create(this, R.raw.fallo)
            sonido(fallo,1000)
            secuencia.clear()
        }else{
            if(secuencia.get(0).equals(color)){
                secuencia.removeAt(0)
                acierto = MediaPlayer.create(this, R.raw.acierto)
                sonido(acierto,700)
                puntuacion--
                if(secuencia.isEmpty()){
                    numero++
                    next = MediaPlayer.create(this, R.raw.next)
                    runBlocking {
                        delay(500L)
                        sonido(next,1000)
                    }
                    mostrarSecuencia(numero)
                }
                findViewById<TextView>(R.id.npuntuacion).setText(puntuacion.toString())
            }else{
                numero=3
                puntuacion=0
                Toast.makeText(this,"Error...Thanos ha chasqueado los dedos", Toast.LENGTH_SHORT).show()
                fallo = MediaPlayer.create(this, R.raw.fallo)
                sonido(fallo,1000)
                secuencia.clear()
            }
        }
    }

    /**
     * Recibe un sonido y lo reproduce durante un tiempo determinado
     * @sonido: MediaPlayer con el sonido que se va a reproducir
     * @tiempo: Tiempo en el cuál se va a reproducir @sonido
     */
    private fun sonido(sonido: MediaPlayer,tiempo: Long){
        sonido.start()
        GlobalScope.launch(Dispatchers.Main) {
            delay(tiempo)
            sonido.stop()
            sonido.release()
        }
    }

}