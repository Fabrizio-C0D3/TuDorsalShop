package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tudorsalshop.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupListeners()
    }

    private fun setupUI() {
        // Mock players for the dropdown
        val players = arrayOf("Lamine Yamal (19)", "Vinícius Jr (7)", "Erling Haaland (9)", "Custom Name")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, players)
        binding.actvPlayer.setAdapter(adapter)

        // In a real app, we would get product details from intent
        // binding.tvDetailTeam.text = intent.getStringExtra("teamName")
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnAddToCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}