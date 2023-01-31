package com.example.cliente

import java.io.PrintWriter
import java.net.Socket


class Hilo(var ip: String, var puerto: Int, var cord:String) : Thread() {

    //PARA QUE FUNCIONE Y NO SALTE -> socket failed: eperm (operation not permitted)
    // Añadir al AndroidManifest.xml la siguiente linea:
    //<uses-permission android:name="android.permission.INTERNET"/>

    private lateinit var client: Socket
    private lateinit var out: PrintWriter

    override fun run() {
        super.run()
        client = Socket(ip, puerto)
        out = PrintWriter(client.getOutputStream(), true)
        out.println(cord)
        out.close()
        client.close()
    }
}