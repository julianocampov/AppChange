package com.jovel.appchange

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jovel.appchange.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)
        this.setTitle(R.string.register)

        registerBinding.checkinButton.setOnClickListener{
            val nombre = registerBinding.nameEditText.text.toString()
            val correo = registerBinding.emailEditText.text.toString()
            val contra = registerBinding.passwordEditText.text.toString()
            val reppassword = registerBinding.repPasswordEditText.text.toString()
            registerBinding.passwordTextInputLayout.error = null
            registerBinding.repPasswordTextInputLayout.error = null

            if(nombre.isNotEmpty() && correo.isNotEmpty() && contra.isNotEmpty() && reppassword.isNotEmpty()) {
                if (contra.length >= 6) {
                    if (contra == reppassword) {
                        val intent = Intent(this, LoginActivity::class.java)
                        intent.putExtra("correo", correo)
                        intent.putExtra("contraseña", contra)
                        intent.putExtra("nombre", nombre)
                        intent.putExtra("band", 1)
                        startActivity(intent)
                        finish()
                    } else registerBinding.repPasswordTextInputLayout.error = getString(R.string.password_not_match)

                }
                else if (contra != reppassword){
                    registerBinding.repPasswordTextInputLayout.error = getString(R.string.password_not_match)
                    registerBinding.passwordTextInputLayout.error = getString(R.string.password_length)
                }
                else {
                    registerBinding.passwordTextInputLayout.error = getString(R.string.password_length)
                }
            }
            else Toast.makeText(this, getString(R.string.missing_data), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
