package com.jovel.appchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.jovel.appchange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val datos = intent.extras
        val correo = datos?.getString("correo")
        val nombre = datos?.getString("nombre")

        mainBinding.emailTextView.text = correo
        mainBinding.nameTextView.text = nombre
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu -> {
                val datos = intent.extras
                val nombre = datos?.getString("nombre")
                val correo = datos?.getString("correo")
                val contra = datos?.getString("contraseña")
                val intent = Intent(this, LoginActivity::class.java)

                intent.putExtra("correo", correo)
                intent.putExtra("contraseña", contra)
                intent.putExtra("nombre", nombre)
                intent.putExtra("band",0)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}