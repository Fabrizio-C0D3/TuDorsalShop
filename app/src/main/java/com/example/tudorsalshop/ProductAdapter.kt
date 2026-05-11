package com.example.tudorsalshop

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tudorsalshop.databinding.ItemProductBinding

class ProductAdapter(
    private val products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = products[position]

        with(holder.binding) {

            tvTeam.text = product.teamName

            tvPrice.text = "$${product.price}"

            tvDiscount.text =
                "${product.discount}% OFF"

            ivProduct.setImageResource(
                product.imageResource
            )

            btnAdd.setOnClickListener {

                val intent = Intent(
                    root.context,
                    ProductDetailsActivity::class.java
                )

                root.context.startActivity(intent)
            }
            root.setOnClickListener {

                val intent = Intent(
                    root.context,
                    ProductDetailsActivity::class.java
                )

                root.context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return products.size
    }
}