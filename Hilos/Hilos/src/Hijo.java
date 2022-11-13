import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {

    public static void main(String[] args) {

        String leer,usuario,contrasenia,mensaje="";
        BufferedReader bufferedReader = null;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            leer = new String();
            leer = br.readLine();

            usuario = leer.split(" ")[0];
            contrasenia = leer.split(" ")[1];

            Hilo hilo = new Hilo(usuario,contrasenia);
            //Hilo hilo2 = new Hilo(usuario,contrasenia);

            hilo.start();
            //hilo2.start();

            hilo.join();
            //hilo2.join();

            mensaje = hilo.getMensaje();

            System.out.println(mensaje);

        } catch (IOException | InterruptedException e) {
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

    static class Hilo extends Thread {
        private String usuario, contrasenia, mensaje;

        public Hilo(String usuario, String contrasenia) {
            this.usuario = usuario;
            this.contrasenia = contrasenia;
        }

        public void buscarUsuario() {
            long tiempoInicio = System.currentTimeMillis();
            String lectura, mensaje = "";
            BufferedReader bufferedReader;

            try {
                bufferedReader = new BufferedReader(new FileReader("src/entrega.txt"));
                while ((lectura = bufferedReader.readLine()) != null) {
                    if (usuario.equalsIgnoreCase(lectura.split(" ")[0]) && contrasenia.equalsIgnoreCase(lectura.split(" ")[1])) {
                        mensaje = "usuario y contraseña correctas. ";

                        break;
                    } else {
                        mensaje = "usuario o contraseña incorrectas. ";
                    }
                }
                long totalTiempo = System.currentTimeMillis() - tiempoInicio;
                this.mensaje = mensaje + "La busqueda ha tardado: " + totalTiempo + " miliseg";
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        @Override
        public void run() {
            buscarUsuario();
        }

        public String getMensaje() {
            return mensaje;
        }

    }

}
