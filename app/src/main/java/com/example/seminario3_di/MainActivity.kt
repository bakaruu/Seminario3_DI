package com.example.seminario3_di

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.seminario3_di.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btmEjercicio1: Button
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        btmEjercicio1 = binding.btnEjercicio1
        binding.btnEjercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }
    }


}