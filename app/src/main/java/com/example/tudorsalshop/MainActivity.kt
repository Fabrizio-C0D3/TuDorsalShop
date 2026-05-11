package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Redirigir al catálogo por defecto
        startActivity(Intent(this, CatalogActivity::class.java))
        finish()
    }
}