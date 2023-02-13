import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIcalcClient {
    public static void main(String[] args) {

        RMIcalcInterface calcu ;

        try {
            Registry registry = LocateRegistry.getRegistry("localhost",5555);
            calcu = (RMIcalcInterface) registry.lookup("Calculadora");

        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(calcu.suma(1, 5));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
