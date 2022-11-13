import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {

    public static void main(String[] args) {
        String leer =" ";
        String lectura,usuario,contrasenia,mensaje = "";
        BufferedReader bufferedReader = null;

        try {
            // BufferedReader para recibir datos del padre
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();
            leer = br.readLine();

            usuario = leer.split(" ")[0];
            contrasenia = leer.split(" ")[1];

            bufferedReader = new BufferedReader(new FileReader("src/entreja.txt"));

            while ((lectura = bufferedReader.readLine()) != null) {
                if (usuario.equalsIgnoreCase(lectura.split(" ")[0]) && contrasenia.equalsIgnoreCase(lectura.split(" ")[1])){
                    mensaje = "Usuario y contraseña correctas";
                    break;
                }else{
                    mensaje = "Usuario o contraseña incorrectas";
                }
            }

            System.out.println(mensaje);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}