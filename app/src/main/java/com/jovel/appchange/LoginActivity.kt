package com.jovel.appchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jovel.appchange.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.loginButton.setOnClickListener{

            val intent = Intent(this,MainActivity::class.java)                  //Se nombra "intent" haciendo referencia a "Intent", Intent funciona Intent(de donde estoy, para donde voy)
            intent.putExtra("email", loginBinding.emailEditText.text.toString())        //Envía la información
            startActivity(intent)                                                              //Ejecuta la sentencia

        }

        loginBinding.registerButton.setOnClickListener{
            val intent =Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}