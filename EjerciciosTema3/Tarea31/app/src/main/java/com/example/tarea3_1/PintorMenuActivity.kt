package com.example.miprimeraapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

open class PintorMenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

   lateinit var layoutPintor : DrawerLayout


    /**
     * Funcion que sobreescribe el método setContentView(view: View?)
     *
     * Se encarga de recoger la barra de la app, el menu, el NavigationView y el layout que se mostrará
     * en la actividad que corresponda
     */
    override fun setContentView(view: View?) {
        layoutPintor = layoutInflater.inflate(R.layout.activity_pintor_menu, null) as DrawerLayout

        //Recogemos el container donde se mostrarán las páginas
        val container:FrameLayout = layoutPintor.findViewById(R.id.contenedor_actividad)
        //Añadimos la vista que nos llega del parámetro al container
        container.addView(view)
        super.setContentView(layoutPintor)
        //Recogemos la barra de la app y la establecemos como nuestra barra de apoyo
        val barra : MaterialToolbar = layoutPintor.findViewById(R.id.barra_app)
        setSupportActionBar(barra)
        //Recogemos tambien nuestro NavigationView, que será la máscara de nuestro menú
        val navView : NavigationView = layoutPintor.findViewById(R.id.navigation_view)
        navView.setNavigationItemSelectedListener(this)

        //Declaramos un ActionBarDrawerToggle y le daremos la actividad en la que nos encontramos,
        // el container, la barra y dos acciones para abrir y cerrar este pintor.
        val toggle : ActionBarDrawerToggle = ActionBarDrawerToggle(this, layoutPintor, barra,
                    R.string.menu_drawer_open, R.string.meu_drawer_close)
        //le damos el toggle al layout para que lo pinte como debe
        layoutPintor.addDrawerListener(toggle)
         toggle.syncState()
    }


    /**
     * Función que se encarga de distribuir que actividad se lanzará cuando se pulse
     * uno de los items del menu del navigationView
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        layoutPintor.closeDrawer(GravityCompat.START)
        when(item.itemId){
            R.id.nav_suma ->{
                startActivity(Intent(this, SumaActivity::class.java))
                overridePendingTransition(0,0)
            }
            R.id.nav_galeria -> {
                startActivity(Intent(this, GaleriaActivity::class.java))
                overridePendingTransition(0,0)
            }
            R.id.nav_checkboxes -> {
                startActivity(Intent(this, CheckBoxesActivity::class.java))
                overridePendingTransition(0,0)
            }
            R.id.nav_cambio_color_texto -> {
                startActivity(Intent(this, CambioColorActivity::class.java))
                overridePendingTransition(0,0)
            }
            R.id.nav_alinear_texto -> {
                startActivity(Intent(this, AlinearText::class.java))
                overridePendingTransition(0,0)
            }
            R.id.nav_modificar_tam -> {
                startActivity(Intent(this, CambiarSizeLetraActivity::class.java))
                overridePendingTransition(0,0)
            }
            R.id.nav_volumen -> {
                startActivity(Intent(this, SuprimirVolumenActivity::class.java))
                overridePendingTransition(0,0)
            }
            }
        return false
        }


    /**
     * Función que se encarga de cambiar el título cada página
     * que aparece en la barra de la app
     */
    protected fun allocateActivityTitle(tituloString : String)
    {
        if(supportActionBar != null){
            supportActionBar?.title = tituloString
        }
    }

    /**
     * Función que sirve para, cuando está el navView abierto, poder cerrarlo
     * pulsando el boton "back"
     */
    fun cerrarNavView(view : View){
        layoutPintor.closeDrawer(GravityCompat.START)
    }

}