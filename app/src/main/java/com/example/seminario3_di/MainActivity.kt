package com.example.seminario3_di

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.seminario3_di.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btnEjercicio1: Button
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnEjercicio2: Button
    private lateinit var btnEjercicio3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        btnEjercicio1 = binding.btnEjercicio1
        binding.btnEjercicio1.setOnClickListener {
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }
        btnEjercicio2 = binding.btnEjercicio2
        binding.btnEjercicio2.setOnClickListener {
            val intent = Intent(this, Ejercicio2::class.java)
            startActivity(intent)
        }

        btnEjercicio3 = binding.btnEjercicio3
        binding.btnEjercicio3.setOnClickListener {
            val intent = Intent(this, Ejercicio3::class.java)
            startActivity(intent)
        }
    }


}