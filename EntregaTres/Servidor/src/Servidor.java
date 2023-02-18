
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        ServerSocket servidor;
        BufferedReader br;
        String lectura = "";

        int socket = 1234;

        try {
            System.out.println(InetAddress.getLocalHost());
            System.out.println("Puerto: " + socket);
            servidor = new ServerSocket(socket);

            while (!lectura.equalsIgnoreCase("parar")) {
                Socket cliente = servidor.accept();
                br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                lectura = br.readLine();
                System.out.println(lectura);
                cliente.close();
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}