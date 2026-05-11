package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Usamos el layout directamente para evitar errores de ViewBinding en el arranque
        setContentView(R.layout.activity_splash)

        // Pequeño retardo para mostrar el logo y luego ir al Login
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, 2000) // 2 segundos es suficiente para un Splash
    }
}