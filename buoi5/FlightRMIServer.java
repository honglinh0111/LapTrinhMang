//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class FlightRMIServer {

	public static void main(String[] args) {
		try {
			if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
			//Tao doi tuong cho phep goi tu xa
			do{
				FlightRMI f1 = new FlightRMI();
				f1.nhap();
				f1.hienThi();
				//Dang ky dt cho phep goi tu xa
				Naming.rebind("Flight1", f1);
				System.out.println("\nDa dang ky mot doi tuong goi tu xa");
			}while (true);			
			
		}
		catch(RemoteException e) {
			System.out.println("Loi khi tao hoac dang ky doi tuong goi tu xa");
		}
		catch(MalformedURLException e) {
			System.out.println("Ten dang ky sai dinh dang URL");
		}

	}

}
