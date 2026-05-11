package com.example.tudorsalshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.tudorsalshop.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupListeners()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupListeners() {
        // Simple visualization logic
        binding.tietCardName.addTextChangedListener { text ->
            binding.tvCardDisplayName.text = if (text.isNullOrBlank()) "FABRIZIO BRACAMONTE" else text.toString().uppercase()
        }

        binding.tietCardNumber.addTextChangedListener { text ->
            if (!text.isNullOrBlank()) {
                binding.tvCardDisplayNumber.text = text.toString().chunked(4).joinToString(" ")
            } else {
                binding.tvCardDisplayNumber.text = "**** **** **** 1234"
            }
        }

        binding.btnPay.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
        }
    }
}