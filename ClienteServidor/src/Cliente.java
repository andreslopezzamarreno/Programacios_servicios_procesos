import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        Socket cliente;

        PrintStream ps;
        BufferedReader br;
        try {
            cliente = new Socket("192.168.1.128", 9999);
            PrintWriter out = new PrintWriter(cliente.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader
                    (new InputStreamReader(cliente.getInputStream()));

            /*ps = new PrintStream(cliente.getOutputStream());*/

            out.println("hola");
            System.out.println(in.readLine());

            out.close();
            in.close();
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
