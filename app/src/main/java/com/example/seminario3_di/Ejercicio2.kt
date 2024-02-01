package com.example.seminario3_di

import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.seminario3_di.databinding.ActivityEjercicio2Binding

class Ejercicio2 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio2Binding

    private lateinit var carta1: ImageView
    private lateinit var carta2: ImageView
    private lateinit var carta3: ImageView

    private val cards = arrayOf(
        R.drawable.carta1,
        R.drawable.carta2,
        R.drawable.carta3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        carta1 = binding.imageViewCarta1
        carta2 = binding.imageViewCarta2
        carta3 = binding.imageViewCarta3
    }

    fun voltearCarta(view: View) {
        val cartaSeleccionada = view as ImageView

        // Obtener el índice de la carta seleccionada
        val indice = when (cartaSeleccionada.id) {
            R.id.imageViewCarta1 -> 0
            R.id.imageViewCarta2 -> 1
            R.id.imageViewCarta3 -> 2
            else -> -1
        }

        val imagenCarta = cards[indice]

        // Cambiar la imagen de la carta después de un breve retraso
        Handler().postDelayed({
            cartaSeleccionada.setImageResource(imagenCarta)
        }, 250)

        // Cambiar la imagen de la carta de nuevo después de otro retraso
        Handler().postDelayed({
            cartaSeleccionada.setImageResource(R.drawable.trasera)
        }, 1000)
    }
}
