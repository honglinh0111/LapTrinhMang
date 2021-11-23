import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Tao lop cai dat cho interface

public class Hello extends UnicastRemoteObject implements HelloInterface{
	// Ham xay dung
	public Hello() throws RemoteException {
		super();
	}
	// Dinh nghia cac ham goi tu xa
	public String sayHello() {
		return "Hello RMI";
	}
}