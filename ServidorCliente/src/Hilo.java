import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.ClientInfoStatus;

public class Hilo extends Thread{

    private Socket cliente = null;

    public Hilo(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        super.run();
        try {
            PrintWriter out = new PrintWriter(cliente.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(cliente.getInputStream()));
            String inputLine = in.readLine();

            System.out.println("Recibido: " +inputLine);
            out.println("Nos ha llegado el mensaje");

            out.close();
            in.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
