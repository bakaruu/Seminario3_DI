package com.example.seminario3_di
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.seminario3_di.databinding.ActivityEjercicio1Binding

class Ejercicio1 : AppCompatActivity() {

    private lateinit var tvEjercicio1: TextView
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var binding: ActivityEjercicio1Binding
    private var tiempoTotal: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        tvEjercicio1 = binding.tvEjercicio1

        // Inicia el temporizador solo si savedInstanceState es nulo, es decir, si es la primera vez que se crea la actividad
        if (savedInstanceState == null) {
            iniciarTemporizador(tiempoTotal)
        }
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
                val intent = Intent(this@Ejercicio1, Ejercicio1Boom::class.java)
                startActivity(intent)
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        // Reinicia el temporizador cuando la actividad se reanuda
        iniciarTemporizador(tiempoTotal)
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