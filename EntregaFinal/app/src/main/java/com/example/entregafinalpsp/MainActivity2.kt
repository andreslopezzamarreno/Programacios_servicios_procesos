package com.example.entregafinalpsp

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import com.example.cliente.Hilo
import com.example.entregafinalpsp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(),OnTouchListener, OnClickListener {
//OnTouchListener,
    private lateinit var binding: ActivityMain2Binding
    private lateinit var hilo: Hilo
    private var posInicialX: Int = 0
    private var posInicialY: Int = 0
    private var x: Int = 0
    private var y: Int = 0
    private lateinit var mensaje:String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.surface.setOnTouchListener(this)
        /*binding.surface.setOnTouchListener { ->

            if (event?.action == MotionEvent.ACTION_MOVE){
                x = event.x.toInt()
                y = event.y.toInt()
                val coordenadas:String = ((x - posInicialX) * 2).toString() +" " + ((y - posInicialY) * 2).toString()
            }

        }*/
        binding.botonDerecho.setOnClickListener(this)
        binding.botonIzquierdo.setOnClickListener(this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (v?.id) {
            binding.surface.id -> {
                if (event?.action == MotionEvent.ACTION_MOVE) {
                    x = event.x.toInt()
                    y = event.y.toInt()
                    val coordenadas:String = ((x - posInicialX) * 2).toString() +" " + ((y - posInicialY) * 2).toString()
                    //Sin añadir el hilo da error -> android.os.NetworkOnMainThreadException
                    //Que es que el metodo Main no puede hacer la conexion a internet
                    if(esRelleno()){
                        hilo = Hilo(
                            binding.textServidor.text.toString(),
                            binding.textPuerto.text.toString().toInt(),
                            coordenadas
                        )
                        hilo.start()
                    }
                } else if (event?.action == MotionEvent.ACTION_DOWN) {
                    posInicialX = event.x.toInt()
                    posInicialY = event.y.toInt()
                }
            }
        }
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonDerecho.id ->{
                mensaje = "derecho"
            }
            binding.botonIzquierdo.id ->{
                mensaje = "izquierdo"
            }
        }
        if(esRelleno()){
            hilo = Hilo(
                binding.textServidor.text.toString(),
                binding.textPuerto.text.toString().toInt(),
                mensaje
            )
            hilo.start()
        }
    }

    private fun esRelleno():Boolean{
        return !(binding.textServidor.text.isEmpty()||binding.textPuerto.text.isEmpty())
    }
}