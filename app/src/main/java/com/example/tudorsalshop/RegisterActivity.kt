package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
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
            val name = binding.tietFullName.text.toString()
            val email = binding.tietEmail.text.toString()
            val password = binding.tietPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "¡Fichaje completado!", Toast.LENGTH_SHORT).show()
                finish() // Volver al Login
            } else {
                Toast.makeText(this, getString(R.string.error_empty), Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignInLink.setOnClickListener {
            finish()
        }
    }
}