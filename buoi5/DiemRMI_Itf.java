import java.rmi.Remote;
import java.rmi.RemoteException;

interface DiemRMI_Itf extends Remote{
	public String layToaDo() throws RemoteException;
	public void ganToaDo(int h, int t) throws RemoteException;
	public void doiDiem(int dx, int dy) throws RemoteException;
}
