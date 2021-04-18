package com.jovel.appchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jovel.appchange.databinding.ActivityLoginBinding

private const val EMPTY = ""

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        val data = intent.extras
        val nombre = data?.getString("nombre")
        val correo = data?.getString("correo")
        val contra = data?.getString("contraseña")
        val band = data?.getInt("band")

        if (band == 1){
            loginBinding.emailEditText.setText(correo)
            loginBinding.passwordEditText.setText(contra)
        }
        else{
            loginBinding.emailEditText.setText(EMPTY)
            loginBinding.passwordEditText.setText(EMPTY)
        }

        loginBinding.loginButton.setOnClickListener{
            if(loginBinding.emailEditText.text.toString().isNotEmpty() && loginBinding.passwordEditText.text.toString().isNotEmpty()){
                if(loginBinding.emailEditText.text.toString() == correo && loginBinding.passwordEditText.text.toString() == contra){
                    val intent = Intent(this,MainActivity::class.java)                  //Se nombra "intent" haciendo referencia a "Intent", Intent funciona Intent(de donde estoy, para donde voy)
                    intent.putExtra("correo", correo)                                           //Envía la información
                    intent.putExtra("nombre", nombre)
                    intent.putExtra("contraseña", contra)
                    startActivity(intent)                                                              //Ejecuta la sentencia
                    finish()
                }
                else Toast.makeText(this, getString(R.string.warning_login), Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this, getString(R.string.warning_login_empty), Toast.LENGTH_SHORT).show()
        }

        loginBinding.registerButton.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}