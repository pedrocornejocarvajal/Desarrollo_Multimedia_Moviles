package com.example.tarea1_4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    companion object{
        private const val CHANNEL_ID ="Channel";
        private const val TAG ="Main Activity";
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "tarea 2-2"
            val descriptionText = "Mensaje del log"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart();
        Log.d(TAG,"En inicio, Pedro Cornejo Carvajal")

        createNotificationChannel()

        val audio = MediaPlayer.create(this, R.raw.beti)
        audio.start()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID).also {
            it.setContentTitle("Tarea 2-2")
            it.setContentText("Aplicacion en Inicio, Pedro Cornejo Carvajal")
            it.setSmallIcon(R.drawable.ic_stat_name)
            it.setPriority(NotificationCompat.PRIORITY_HIGH)
        }
      with(NotificationManagerCompat.from(this)){
           notify(2,notification.build())
        }
    }

    override fun onRestart() {
        super.onRestart();
        Log.d(TAG,"En Reinicio, Pedro Cornejo Carvajal")

    }
    override fun onResume() {
        super.onResume();
        Log.d(TAG,"En Resume, Pedro Cornejo Carvajal")
        setContentView(R.layout.activity_main)

    }
    override fun onPause() {

        super.onPause();
        Log.d(TAG,"En pausa, Pedro Cornejo Carvajal")
        setContentView(R.layout.layaout2)

        createNotificationChannel()

        val notification = NotificationCompat.Builder(this, CHANNEL_ID).also {
            it.setContentTitle("Tarea 2-2")
            it.setContentText("Aplicacion en pausa, Pedro Cornejo Carvajal")
            it.setSmallIcon(R.drawable.ic_stat_name)
            it.setPriority(NotificationCompat.PRIORITY_HIGH)
        }
        with(NotificationManagerCompat.from(this)){
            notify(2,notification.build())
        }
    }
    override fun onStop() {

        super.onStop();
        Log.d(TAG,"En segundo plano, Pedro Cornejo Carvajal")
        setContentView(R.layout.layaout2)

    }
    override fun onDestroy() {

        super.onDestroy();
        Log.d(TAG,"En destruccion, Pedro Cornejo Carvajal")
    }
}