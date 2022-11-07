public class Carrera {
    public static void main(String[] args) {
        Liebre liebre = new Liebre("liebre",2);
        Tortuga tortuga = new Tortuga("liebre",5);

        liebre.start();
        tortuga.start();
    }
}
