package com.example.cliente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cliente.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var hilo: Hilo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonEnviar.setOnClickListener {
            if (binding.textServidor.text.isEmpty() || binding.textPuerto.text.isEmpty() || binding.textEnviar.text.isEmpty()) {
                Snackbar.make(
                    findViewById(R.id.botonEnviar),
                    "Falta algun Dato por Introducir",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                //Sin añadir el hilo da error -> android.os.NetworkOnMainThreadException
                //Que es que el metodo Main no puede hacer la conexion a internet

                hilo = Hilo(
                    binding.textServidor.text.toString(),
                    binding.textPuerto.text.toString().toInt(),
                    binding.textEnviar.text.toString()
                )
                hilo.start()
                binding.textEnviar.setText("")
            }
        }
    }
}