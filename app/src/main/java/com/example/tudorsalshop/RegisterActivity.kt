package com.example.tudorsalshop

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tudorsalshop.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnRegisterSubmit.setOnClickListener {
            if (validateForm()) {
                // Lógica para crear cuenta
                Toast.makeText(this, "Procesando registro...", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignInLink.setOnClickListener {
            finish() // Regresa al Login
        }
    }

    private fun validateForm(): Boolean {
        val name = binding.tietFullName.text.toString()
        val email = binding.tietRegisterEmail.text.toString()
        val password = binding.tietRegisterPassword.text.toString()
        var isValid = true

        // Validación Nombre
        if (name.isEmpty()) {
            binding.tilFullName.error = getString(R.string.error_empty)
            isValid = false
        } else {
            binding.tilFullName.error = null
        }

        // Validación Email
        if (email.isEmpty()) {
            binding.tilRegisterEmail.error = getString(R.string.error_empty)
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilRegisterEmail.error = getString(R.string.error_email)
            isValid = false
        } else {
            binding.tilRegisterEmail.error = null
        }

        // Validación Contraseña
        if (password.isEmpty()) {
            binding.tilRegisterPassword.error = getString(R.string.error_empty)
            isValid = false
        } else if (password.length < 8) {
            binding.tilRegisterPassword.error = getString(R.string.error_password)
            isValid = false
        } else {
            binding.tilRegisterPassword.error = null
        }

        return isValid
    }
}