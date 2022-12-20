package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.example.miprimeraapp.databinding.ActivityGaleriaBinding
import com.gtappdevelopers.kotlingfgproject.ViewPagerAdapter
import java.util.jar.Attributes

class GaleriaActivity : PintorMenuActivity() {
    // on below line we are creating variable for view pager,
    // viewpager adapter and the image list.
    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var imageList: List<Int>

    lateinit var activityGaleriaBinding : ActivityGaleriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGaleriaBinding = ActivityGaleriaBinding.inflate(layoutInflater)
        setContentView(activityGaleriaBinding.root)
        overridePendingTransition(0,0)
        allocateActivityTitle("Galeria")

        // inicializaamos la variable del viewPager que mostrará nuestras imagenes
        viewPager = findViewById(R.id.idViewPager)

        // inicializamos la lista de imagenes
        imageList = ArrayList<Int>()
        imageList = imageList + R.mipmap.java
        imageList = imageList + R.mipmap.kotlin
        imageList = imageList + R.mipmap.cplus
        imageList = imageList + R.mipmap.ic_launcher



        // generamos el ViewPagerAdapter que servirá para cambiar de imagen deslizando
        //en nuestra pantalla
        viewPagerAdapter = ViewPagerAdapter(this@GaleriaActivity, imageList)

        // introducimos el adapter en nuestro viewPage
        viewPager.adapter = viewPagerAdapter
        val btnAnterior : Button = findViewById(R.id.btnAnterior)
        val btnSiguiente : Button = findViewById(R.id.btnSiguiente)


        //Método que hace que, cuando se clica el btnSiguiente,
        //si la imagen que tenemos es la última, v uelva a la primera y que,
        //si no es la ultima, avance a la siguiente imagen
        var posicion = 0
        btnSiguiente?.setOnClickListener {
            if(viewPager.currentItem == imageList.size-1){
                viewPager.currentItem = 0
            }else
                viewPager.currentItem += 1

        }
        //Método que hace que, cuando se clica el btnAnterior,
        //si la imagen que tenemos es la primera, vuelva a la última y que,
        //si no es la primera, retroceda a la imagen anterior
        btnAnterior?.setOnClickListener {
            if(viewPager.currentItem == 0){
                viewPager.currentItem = viewPager.bottom
            }else
            viewPager.currentItem -= 1

        }

    }


}