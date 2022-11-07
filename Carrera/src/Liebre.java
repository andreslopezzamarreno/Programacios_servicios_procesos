public class Liebre extends Thread{

    String nombre;
    int tiempoCarrera;


    public Liebre(String nombre,int tiempoCarrera) {
        this.nombre = nombre;
        this.tiempoCarrera = tiempoCarrera;
    }
    public void correr(){
        try{
            System.out.printf("\n%s ha empezado a correr",getClass().getName());
            Thread.sleep(tiempoCarrera*1000);
            System.out.printf("\n%s ha terminado de correr",getClass().getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        correr();
    }
}
