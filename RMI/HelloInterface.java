import java.rmi.Remote;
import java.rmi.RemoteException;

interface HelloInterface extends Remote {
	// Khai bao cac ham goi tu xa
	public String sayHello() throws RemoteException;
}
