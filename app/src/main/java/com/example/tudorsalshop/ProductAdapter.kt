package com.example.tudorsalshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tudorsalshop.databinding.ItemProductBinding

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        val binding = holder.binding
        
        binding.tvTeamName.text = product.teamName
        binding.tvSeason.text = product.season
        binding.tvPrice.text = "$${product.price}"
        binding.tvDiscountTag.text = "${product.discount}% OFF"
        binding.ivProductImage.setImageResource(product.imageResource)

        binding.fabFavorite.setOnClickListener {
            product.isFavorite = !product.isFavorite
            binding.fabFavorite.setImageResource(
                if (product.isFavorite) android.R.drawable.btn_star_big_on 
                else android.R.drawable.btn_star_big_off
            )
        }
    }

    override fun getItemCount() = products.size
}
