package com.example.cliente

import java.io.PrintWriter
import java.net.Socket


class Hilo(var ip:String, var puerto:Int,var mensaje:String) : Thread() {
    //PARA QUE FUNCIONE Y NO SALTE "socket failed: eperm (operation not permitted)"
    // AÑADIR AL AndroidManifest.xml la siguiente linea
        //<uses-permission android:name="android.permission.INTERNET"/>

    private lateinit var client: Socket
    private lateinit var out: PrintWriter

    override fun run() {
        super.run()
        client = Socket(ip, puerto)
        out = PrintWriter(client.getOutputStream(), true)
        out.println(mensaje)
        out.close()
        client.close()
        //"192.168.1.128", 1234
    }


}