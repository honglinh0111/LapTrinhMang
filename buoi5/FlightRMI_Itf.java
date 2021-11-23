//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.rmi.Remote;
import java.rmi.RemoteException;

interface FlightRMI_Itf extends Remote{
	//Khai bao cac ham goi tu xa
	public String flightInfo() throws RemoteException;
	public void ticketBuyMethod(int a) throws RemoteException;
	public void ticketPayMethod(int b) throws RemoteException;
}
