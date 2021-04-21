package com.jovel.appchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.jovel.appchange.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var nombre: String
    private lateinit var correo: String
    private lateinit var contra: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(loginBinding.root)

        chargeData()
        onChangeListener()
        buttonsListeners()

    }


    private fun chargeData() {
        val data = intent.extras
        nombre = data?.getString("nombre").toString()
        correo = data?.getString("correo").toString()
        contra = data?.getString("contraseña").toString()
        val band = data?.getInt("band")

        if (band == 1){
            loginBinding.emailEditText.setText(correo)
            loginBinding.passwordEditText.setText(contra)
        }
        else{
            loginBinding.emailEditText.setText(EMPTY)
            loginBinding.passwordEditText.setText(EMPTY)
        }
    }

    private fun buttonsListeners() {
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

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onChangeListener() {
        loginBinding.emailEditText.doAfterTextChanged {
                validateEmail()
            }
    }

    private fun validateEmail() {
        with(loginBinding) {
            emailTextInputLayout.error = if ((emailEditText.text.toString()== EMPTY))  null
                                         else if (!emailValidator(emailEditText.text.toString())) getString(R.string.enter_valid_email)
                                         else null
        }
    }
}