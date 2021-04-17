package com.jovel.appchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.jovel.appchange.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val datos = intent.extras
        val nombre = datos?.getString("nombre")
        val correo = datos?.getString("correo")

        mainBinding.emailTextView.text = correo
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.logout_menu -> {
                val datos = intent.extras
                val nombre = datos?.getString("nombre")
                val correo = datos?.getString("correo")
                val contraseña = datos?.getString("contraseña")
                val intent = Intent(this, LoginActivity::class.java)

                intent.putExtra("correo", correo)
                intent.putExtra("contraseña", contraseña)
                intent.putExtra("nombre", nombre)
                intent.putExtra("band",0)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }
}