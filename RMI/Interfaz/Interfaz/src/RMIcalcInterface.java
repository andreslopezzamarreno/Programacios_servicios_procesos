import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIcalcInterface extends Remote {
    public int suma (int a,int b) throws RemoteException;
}
