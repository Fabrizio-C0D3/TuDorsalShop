package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tudorsalshop.databinding.ActivityCatalogBinding

class CatalogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCatalogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        setupBottomNavigation()
    }

    private fun setupRecycler() {
        val products = listOf(
            Product(1, "FC Barcelona", "2024/25 Home", 89.99, 25, R.drawable.tudorsalshop3, "La Liga"),
            Product(2, "Real Madrid", "2024/25 Away", 94.99, 15, R.drawable.tudorsalshop3, "La Liga"),
            Product(3, "Man. City", "2024/25 Home", 92.50, 10, R.drawable.tudorsalshop3, "Premier League"),
            Product(4, "Inter Milan", "2024/25 Home", 85.00, 20, R.drawable.tudorsalshop3, "Serie A"),
            Product(5, "Arsenal", "2024/25 Home", 88.99, 5, R.drawable.tudorsalshop3, "Premier League"),
            Product(6, "Liverpool", "2024/25 Away", 90.00, 25, R.drawable.tudorsalshop3, "Premier League")
        )

        binding.rvProducts.layoutManager = GridLayoutManager(this, 2)
        binding.rvProducts.adapter = ProductAdapter(products)
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.selectedItemId = R.id.nav_home
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                    false
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    false
                }
                else -> false
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        binding.bottomNavigation.selectedItemId = R.id.nav_home
    }
}