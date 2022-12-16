package com.example.cliente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cliente.databinding.ActivityMainBinding
import java.io.*
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var hilo: Hilo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonEnviar.setOnClickListener {
            if (binding.textServidor.text.isEmpty() || binding.textPuerto.text.isEmpty() || binding.textEnviar.text.isEmpty()) {
                println("klk")
            } else {
                hilo = Hilo(binding.textServidor.text.toString(),binding.textPuerto.text.toString().toInt(),binding.textEnviar.text.toString())
                hilo.start()

            }
        }
    }
}