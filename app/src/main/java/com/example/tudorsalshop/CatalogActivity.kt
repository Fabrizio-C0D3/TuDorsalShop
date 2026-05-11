package com.example.tudorsalshop

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

        setupRecyclerView()
        setupBottomNavigation()
    }

    private fun setupRecyclerView() {
        val products = listOf(
            Product(1, "FC Barcelona", "Home Jersey 24/25", 89.99, 25, R.mipmap.tudorsalshop3, "La Liga"),
            Product(2, "Real Madrid", "Away Jersey 24/25", 95.00, 10, R.mipmap.tudorsalshop3, "La Liga"),
            Product(3, "Manchester City", "Home Jersey 24/25", 85.50, 15, R.mipmap.tudorsalshop3, "Premier League"),
            Product(4, "Liverpool FC", "Third Jersey 24/25", 80.00, 20, R.mipmap.tudorsalshop3, "Premier League"),
            Product(5, "Juventus", "Home Jersey 24/25", 88.00, 5, R.mipmap.tudorsalshop3, "Serie A"),
            Product(6, "Argentina", "World Cup Edition", 110.00, 0, R.mipmap.tudorsalshop3, "National Teams")
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
                    // Navegar al carrito
                    true
                }
                R.id.nav_profile -> {
                    // Navegar al perfil
                    true
                }
                else -> false
            }
        }
    }
}