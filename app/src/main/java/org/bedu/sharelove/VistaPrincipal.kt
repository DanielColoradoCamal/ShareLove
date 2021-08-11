package org.bedu.sharelove

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_vistaprincipal.view.*
import org.bedu.sharelove.databinding.ActivityMainBinding


class VistaPrincipal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

//    private lateinit var botonArticulo: ImageButton
//    private lateinit var botonComida: ImageButton
//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


//    private lateinit var boton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vistaprincipal)

        val toolbar: Toolbar = findViewById(R.id.app_bar)
        val appBar = findViewById<Toolbar>(R.id.app_bar)
        this.setSupportActionBar(appBar)

        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        toggle =ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        setupDrawer(appBar)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MainFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)


    }
    private fun setupDrawer(toolbar: Toolbar){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)
    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (toggle.onOptionsItemSelected(item)){
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }


    override fun onOptionsItemSelected(item_contact: MenuItem): Boolean {

        when(item_contact.itemId) {
            R.id.shirt -> startActivity(Intent(this, Articulos::class.java))
            R.id.food -> startActivity(Intent(this, Comida::class.java))
            R.id.notificacion -> startActivity(Intent(this, Compartiendo::class.java))

        }

        return super.onOptionsItemSelected(item_contact)
    }

    override fun onNavigationItemSelected(item_contact: MenuItem): Boolean {
        when (item_contact.itemId) {
            R.id.nav_home -> startActivity(Intent(this, Perfil::class.java))
        }
        drawer.closeDrawer(GravityCompat.START)
        return true

    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }


}







//        botonArticulo = findViewById(R.id.imgButtonVerArticulos)
//        botonComida = findViewById(R.id.imgButtonVerComida)

//        botonArticulo.setOnClickListener {
//
//            startActivity(Intent(this, Articulos::class.java))
//        }
//
//        botonComida.setOnClickListener {
//
//            startActivity(Intent(this, Comida::class.java))
//        }