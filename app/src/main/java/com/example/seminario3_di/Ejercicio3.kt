package com.example.seminario3_di

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.seminario3_di.databinding.ActivityEjercicio3Binding

class Ejercicio3 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio3Binding
    private lateinit var semaforo1ImageView: ImageView

    private val handler = Handler()
    private var currentState = 0 // 0: Verde, 1: Amarillo, 2: Rojo
    private var isTimerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        semaforo1ImageView = binding.semaforo
    }

    fun onStartStopButtonClick(view: View) {
        if (isTimerRunning) {
            // Si el temporizador está en ejecución, detenerlo
            stopTimer()
        } else {
            // Si el temporizador no está en ejecución, iniciarlo
            startTimer()
        }
    }

    private fun startTimer() {
        isTimerRunning = true
        handler.postDelayed(object : Runnable {
            override fun run() {
                // Cambia la imagen según el estado actual
                when (currentState) {
                    0 -> { // Verde
                        semaforo1ImageView.setImageResource(R.drawable.verde)
                        currentState = 1 // Cambia a Amarillo
                        handler.postDelayed(this, 2000) // 2 segundos en verde
                    }
                    1 -> { // Amarillo
                        semaforo1ImageView.setImageResource(R.drawable.amarillo)
                        currentState = 2 // Cambia a Rojo
                        handler.postDelayed(this, 1000) // 1 segundo en amarillo
                    }
                    2 -> { // Rojo
                        semaforo1ImageView.setImageResource(R.drawable.rojo)
                        currentState = 0 // Cambia a Verde
                        handler.postDelayed(this, 2000) // 2 segundos en rojo
                    }
                }
            }
        }, 2000) // Inicia con 2 segundos en verde
    }

    private fun stopTimer() {
        isTimerRunning = false
        // Detener el temporizador
        handler.removeCallbacksAndMessages(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Detener el temporizador cuando la actividad se destruye
        handler.removeCallbacksAndMessages(null)
    }

    override fun onPause() {
        super.onPause()
        // Detener el temporizador cuando la actividad se pausa
        handler.removeCallbacksAndMessages(null)

    }

    override fun onResume() {
        super.onResume()
        // Iniciar el temporizador cuando la actividad se reanuda
        if (isTimerRunning) {
            startTimer()
        }
    }
}
