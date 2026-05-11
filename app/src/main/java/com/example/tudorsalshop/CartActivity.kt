package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tudorsalshop.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupRecycler()
        setupListeners()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupRecycler() {
        // Mock cart items using the same product model
        val cartItems = listOf(
            Product(1, "FC Barcelona", "2024/25 Home", 89.99, 25, R.drawable.tudorsalshop3, "La Liga"),
            Product(2, "Real Madrid", "2024/25 Away", 94.99, 15, R.drawable.tudorsalshop3, "La Liga")
        )

        binding.rvCart.layoutManager = LinearLayoutManager(this)
        binding.rvCart.adapter = ProductAdapter(cartItems)
    }

    private fun setupListeners() {
        binding.btnCheckout.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
        }
    }
}