import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientePersona {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("127.0.0.1",9999);
            ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

            Persona persona = (Persona) inObjeto.readObject();
            System.out.println(persona.getNombre());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
