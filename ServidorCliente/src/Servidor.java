import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor;
        BufferedReader br;
        String lectura = "";
        try {
            servidor = new ServerSocket(1234);
            /*while (true){
                new Hilo(servidor.accept()).start();
            }

             */
            while(lectura != "parar"){
                Socket cliente =  servidor.accept();
                br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                lectura= br.readLine();
                System.out.println(lectura);
                cliente.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
