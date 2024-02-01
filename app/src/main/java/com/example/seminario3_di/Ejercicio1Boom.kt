package com.example.seminario3_di

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.seminario3_di.databinding.ActivityEjercicio1IntentBinding

class Ejercicio1Boom: AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio1IntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio1IntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}