//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.rmi.Remote;
import java.rmi.RemoteException;

interface FileRMI_Itf extends Remote{
	public int getLength(String filename) throws RemoteException;
	public byte[] getFile(String filename) throws RemoteException;
}