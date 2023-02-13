import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIcalcServer implements RMIcalcInterface{

    @Override
    public int suma(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        Registry reg;

        try {
            reg = LocateRegistry.createRegistry(5555);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        RMIcalcServer serverObject = new RMIcalcServer();

        try {
            reg.rebind("Calculadora", UnicastRemoteObject.exportObject(serverObject,0));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
