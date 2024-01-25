package com.example.seminario3_di

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.seminario3_di.databinding.ActivityEjercicio1Binding

class Ejercicio1: AppCompatActivity() {

    private lateinit var tvEjercicio1: TextView
    private lateinit var countDownTimer: CountDownTimer

    private lateinit var binding: ActivityEjercicio1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        tvEjercicio1 = binding.tvEjercicio1


        val tiempoTotal: Long = 10000

        // Inicia el temporizador
        iniciarTemporizador(tiempoTotal)


    }

    private fun iniciarTemporizador(tiempoTotal: Long) {
        countDownTimer = object : CountDownTimer(tiempoTotal, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Se llama cada segundo mientras el temporizador está en marcha
                val segundosRestantes = millisUntilFinished / 1000
                tvEjercicio1.text = "$segundosRestantes"
            }

            override fun onFinish() {
                // Se llama cuando el temporizador llega a cero
                tvEjercicio1.text = "¡Tiempo agotado!"
            }
        }

        // Inicia el temporizador
        countDownTimer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Asegúrate de detener el temporizador cuando la actividad se destruye
        countDownTimer.cancel()
    }

    override fun onPause() {
        super.onPause()
        // Asegúrate de detener el temporizador cuando la actividad se pausa
        countDownTimer.cancel()
    }





}