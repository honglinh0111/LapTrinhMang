//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.rmi.*;
import java.net.MalformedURLException;
public class FlightRMIClient {

	public static void main(String[] args) {
		try {
			//Tim doi tuong goi tu xa
			FlightRMI_Itf dtf1 = (FlightRMI_Itf)Naming.lookup("rmi://127.0.0.1/Flight1");
			//Goi ham tren doi tuong goi tu xa
			System.out.println("---Thong tin chuyen bay--- "+ dtf1.flightInfo());
			dtf1.ticketBuyMethod(5);
			System.out.println("\nThong tin chuyen bay sau khi mua them 5 ve: "+ dtf1.flightInfo());
			dtf1.ticketPayMethod(2);
			System.out.println("\nThong tin chuyen bay sau khi tra lai 2 ve "+ dtf1.flightInfo());		
			
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
