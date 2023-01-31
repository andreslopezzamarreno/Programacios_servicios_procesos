package com.example.entregafinalpsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.Toast
import com.example.entregafinalpsp.databinding.ActivityMainBinding
import com.example.entregafinalpsp.dialogs.DialogoSesion
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Encoder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Base64.getEncoder
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import kotlin.math.log

class MainActivity : AppCompatActivity(),DialogoSesion.OnDialogoInterfaz {

    private lateinit var binding: ActivityMainBinding
    private lateinit var botonSesion:Button
    private lateinit var usuarioPasado: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inicioSesion.setOnClickListener{
            DialogoSesion().show(supportFragmentManager,"")
        }
    }

    override fun pasarUsuario(usuario: Usuario) {
        usuarioPasado = usuario
        cifrar(usuarioPasado.pass)
        println("usuario " + usuarioPasado.usuario)
        println("contraseña " + usuarioPasado.pass)
        if (login(usuarioPasado)){
            var intent= Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Usuario o contraseña Incorrecta",Toast.LENGTH_SHORT).show()
        }
    }

    private fun cifrar(contrasenia:String){
        val byteSecretKey:ByteArray = "aG9sYXF1ZXRsYQ==".toByteArray()
        val secretKeySpec = SecretKeySpec(byteSecretKey,"AES")
        //cifrar
        val cipher = Cipher.getInstance("AES")
        //La siguiente linea da error al descifrar, utilizar mejor la de arriba.
        //val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        //val iv: ByteArray = cipher.iv
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec)
        val mensajeEncriptado:ByteArray = cipher.doFinal(contrasenia.toByteArray())
        val passEncriptada = String(mensajeEncriptado)
        usuarioPasado.pass = passEncriptada
        login(usuarioPasado)
        /*
        //descifrado
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec)
        val decipherBytes: ByteArray = cipher.doFinal(mensajeEncriptado)
        val texto2 = String(decipherBytes)
        println(texto2)
         */
    }

    private fun login(usuarioLogin: Usuario):Boolean{
        var lectura:String?
        var br :BufferedReader

        var usuarioLeido = usuarioLogin.usuario
        var passLeido = usuarioLogin.pass

        var filename = "usuarioregistro"
        val inputStream = resources.openRawResource( resources.getIdentifier(
            filename,
            "raw", packageName
        ))

        br = BufferedReader(InputStreamReader(inputStream))
        do{
            lectura = br.readLine()
            println(lectura)
            println(lectura.split(" ")[0])
            return usuarioLeido.equals(lectura.split(" ")[0]) && passLeido.equals(lectura.split(" ")[1])
        }while (lectura != null)

    }

}
