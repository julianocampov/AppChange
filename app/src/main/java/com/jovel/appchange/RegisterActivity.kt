package com.jovel.appchange

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.jovel.appchange.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var nombre: String
    private lateinit var correo: String
    private lateinit var contra: String
    private lateinit var reppassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(registerBinding.root)
        this.setTitle(R.string.register)

        buttonListener()
        onChangeListener()
    }

    private fun buttonListener() {
        registerBinding.checkinButton.setOnClickListener {

            readTextInputs()

            if (notEmptyFields() && validateName() && validateEmail() && validateContra() && validateRepContra()) {
                chargeData()
            }
        }
    }

    private fun onChangeListener() {
        with(registerBinding){

            nameEditText.doAfterTextChanged {
                nameTextInputLayout.error = null
            }

            emailEditText.doAfterTextChanged {
                emailTextInputLayout.error = null
            }

            passwordEditText.doAfterTextChanged {
                passwordTextInputLayout.error = null
            }

            repPasswordEditText.doAfterTextChanged {
                repPasswordTextInputLayout.error = null
            }
        }
    }

    private fun readTextInputs() {
        with(registerBinding) {
            nombre = nameEditText.text.toString()
            correo = emailEditText.text.toString()
            contra = passwordEditText.text.toString()
            reppassword = repPasswordEditText.text.toString()
            passwordTextInputLayout.error = null
            repPasswordTextInputLayout.error = null
        }
    }

    private fun notEmptyFields(): Boolean {
        if(!(nombre.isNotEmpty() && correo.isNotEmpty() && contra.isNotEmpty() && reppassword.isNotEmpty())) Toast.makeText(this, getString(R.string.missing_data), Toast.LENGTH_SHORT).show()
        return nombre.isNotEmpty() && correo.isNotEmpty() && contra.isNotEmpty() && reppassword.isNotEmpty()
    }

    private fun validateName(): Boolean {
        if(lengthString(nombre, USER_NAME_LENGTH)) return true
        registerBinding.nameTextInputLayout.error = getString(R.string.enter_valid_name)
        return lengthString(nombre, USER_NAME_LENGTH)
    }

    private fun validateEmail(): Boolean {
        if(!emailValidator(correo)) {
            registerBinding.emailTextInputLayout.error = getString(R.string.enter_valid_email)
            return false
        }
        return true
    }

    private fun validateContra(): Boolean {
        if(lengthString(contra, PASSWORD_LENGTH)) return true

        registerBinding.passwordTextInputLayout.error = getString(R.string.password_length)
        return lengthString(contra, PASSWORD_LENGTH)
    }

    private fun validateRepContra(): Boolean {
        if ( contra != reppassword ) {
            registerBinding.repPasswordTextInputLayout.error = getString(R.string.password_not_match)
            return false
        }
        return true
    }

    private fun chargeData() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("correo", correo)
        intent.putExtra("contraseña", contra)
        intent.putExtra("nombre", nombre)
        intent.putExtra("band", 1)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
        startActivity(intent)
        finish()
    }
}
