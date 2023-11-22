package com.sayhello

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sayhello.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnSay.setOnClickListener {
            binding.textSay.text = "Hello Kotlin!!!"
        }
    }
}