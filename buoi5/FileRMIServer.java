//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class FileRMIServer {

	public static void main(String[] args) {
		try {
			//Thiet lap co che bao mat
			if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
			
			//Tao doi tuong cho phep goi tu xa
			FileRMI obj = new FileRMI();
			System.out.println("Da khoi tao xong doi tuong FileRMI");
			
			//Dang ky doi tuong cho phep goi tu xa
			Naming.rebind("FileRMI", obj);
			System.out.println("Da dang ky xong doi tuong goi tu xa");
		}
		catch(RemoteException e) {
			System.out.println("Loi khi tao hoac dang ky doi tuong goi tu xa");
		}
		catch(MalformedURLException e) {
			System.out.println("Ten dang ky sai dinh dang URL");
		}

	}

}
