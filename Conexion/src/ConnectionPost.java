import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ConnectionPost {
    public static void main(String[] args) {
        String datos = "nombre=Juan&edad=34";
        URL url ;
        HttpURLConnection hc;
        String inputline;
        BufferedReader br = null;
        try {
            url = new URL("http://localhost/examplepost.php");
            hc = (HttpURLConnection) url.openConnection();
            hc.setRequestMethod("POST");
            hc.setDoOutput(true);
            hc.getOutputStream().write(datos.getBytes(StandardCharsets.UTF_8));
            br = new BufferedReader(new InputStreamReader(hc.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(true) {
            try {
                if (!((inputline = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println(inputline);
        }

        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
