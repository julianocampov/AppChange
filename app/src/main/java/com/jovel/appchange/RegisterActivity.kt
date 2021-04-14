package com.jovel.appchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jovel.appchange.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        registerBinding.checkinButton.setOnClickListener{
            val nombre = registerBinding.nameEditText.text.toString()
            val correo = registerBinding.emailEditText.text.toString()
            val contraseña = registerBinding.passwordEditText.text.toString()

        }



    }
}