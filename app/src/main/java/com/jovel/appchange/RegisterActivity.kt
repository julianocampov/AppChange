package com.jovel.appchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isNotEmpty
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
            val reppassword = registerBinding.repPasswordEditText.text.toString()


            if(nombre.isNotEmpty() && correo.isNotEmpty() && contraseña.isNotEmpty() && reppassword.isNotEmpty()){
                if(contraseña == reppassword){
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.putExtra("correo", correo)
                    intent.putExtra("contraseña", contraseña)
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("band",1)
                    startActivity(intent)
                    finish()
                }
                else registerBinding.repPasswordTextInputLayout.error = "Las contraseñas no coinciden"
            }
            else Toast.makeText(this, "Falta algún campo por rellenar", Toast.LENGTH_SHORT).show()
        }
    }
}
