import java.io.*;
import javax.net.ssl.*;

public class ClienteSSL {
    public static void main(String[] args) throws Exception {
        String Host = "192.168.2.110";
        int puerto = 9999;//puerto remoto

        // Propiedades JSSE)
        System.setProperty("javax.net.ssl.trustStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.trustStorePassword", "1234567");

        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket Cliente = (SSLSocket) sfact.createSocket(Host, puerto);

        // CREO FLUJO DE SALIDA AL SERVIDOR
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

        // ENVIO UN SALUDO AL SERVIDOR
        flujoSalida.writeUTF("Esto es el Cliente. Te saludo Servidor");

        // CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

        // EL servidor ME ENVIA UN MENSAJE
        System.out.println(flujoEntrada.readUTF());

        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        Cliente.close();
    }// main
}