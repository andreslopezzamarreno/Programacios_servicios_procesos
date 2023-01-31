import java.awt.*;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static java.awt.SystemColor.control;

public class Servidor {
    public static void main(String[] args) {
        /*
        public static void main(String[] args) {
        ServerSocket servidor;
        BufferedReader br;
        String lectura = "";

        int socket = 1234;

        try {
            System.out.println(InetAddress.getLocalHost());
            System.out.println("Puerto: " +socket);
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
         */
        int socket = 1234;
        ServerSocket servidor;
        BufferedReader br;
        String cordenadas = "";
        int cordX;
        int cordY;
        Robot control;

        try {
            control = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(InetAddress.getLocalHost());
            System.out.println("Puerto: " +socket);
            servidor = new ServerSocket(socket);
            while (!cordenadas.equalsIgnoreCase("parar")) {
                Socket cliente = servidor.accept();
                br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                cordenadas = br.readLine();

                if (cordenadas.equals("derecho")){
                    //control.mousePress(InputEvent.getMaskForButton(3));
                    control.mouseRelease(InputEvent.getMaskForButton(3));
                    System.out.println("derecho");
                }
                else if (cordenadas.equals("izquierdo")){
                    control.mousePress(InputEvent.getMaskForButton(1));
                    control.mouseRelease(InputEvent.getMaskForButton(1));
                    System.out.println("izquierdo");
                }
                else{

                    int movimientoX =(Integer.parseInt(cordenadas.split(" ")[0]))/100;
                    int movimientoY =(Integer.parseInt(cordenadas.split(" ")[1]))/100;

                    cordX = MouseInfo.getPointerInfo().getLocation().x;
                    cordY = MouseInfo.getPointerInfo().getLocation().y;

                    control.mouseMove(movimientoX+cordX, movimientoY+cordY);

                    System.out.println(cordenadas);

                    cliente.close();
                    br.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}