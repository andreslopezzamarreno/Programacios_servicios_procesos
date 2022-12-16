import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPersona {
    public static void main(String[] args) {
        ServerSocket servidor;
        BufferedReader br;

        try {
            servidor = new ServerSocket(9999);
            Socket cliente =  servidor.accept();
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

            Persona persona = new Persona("juan");
            outObjeto.writeObject(persona);
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
