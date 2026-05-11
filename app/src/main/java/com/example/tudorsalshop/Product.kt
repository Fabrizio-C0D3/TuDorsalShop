package com.example.tudorsalshop

data class Product(
    val id: Int,
    val teamName: String,
    val season: String,
    val price: Double,
    val discount: Int,
    val imageResource: Int,
    val category: String,
    var isFavorite: Boolean = false
)