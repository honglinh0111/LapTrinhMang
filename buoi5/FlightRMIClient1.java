import java.rmi.*;
import java.net.MalformedURLException;
public class FlightRMIClient1 {

	public static void main(String[] args) {
		try {
			//Tim doi tuong goi tu xa
			FlightRMI_Itf dtf1 = (FlightRMI_Itf)Naming.lookup("rmi://127.0.0.1/Flight1");//sai ten: NotBoundException
			//Goi ham tren doi tuong goi tu xa
			dtf1.ticketBuyMethod(10);
//			dtf1.ticketPayMethod(20);
				
		}
		catch(RemoteException e) {
			System.out.println("Loi khi goi ham tu xa");
		}
		catch(NotBoundException e) {
			System.out.println("Khong tin thay doi tuong");
		}
		catch(MalformedURLException e) {
			System.out.println("Sai dinh danh URL cua ten doi tuong");
		}

	}

}
