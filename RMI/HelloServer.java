import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class HelloServer {
	public static void main(String[] args) {
		try {
			// Khoi tao co che bao mat cho RMI
			if(System.getSecurityManager()==null)
				System.setSecurityManager(new RMISecurityManager());
			// Tao doi tuong cho phep goi tu xa
			Hello obj = new Hello();
			System.out.println("Da khoi tao xong doi tuong cho phep goi tu xa");
			// Dang ky doi tuong cho phep goi tu xa
			Naming.rebind("ABC", obj);
			System.out.println("Da dang ky thanh cong doi tuong  voi ten ABC");
		}
		catch( RemoteException e) {
			System.out.println("Loi khi tao hoac dang ky doi tuong tu xa");
		}
		catch(MalformedURLException e) {
			System.out.println("Ten dang ky sai dinh dang URL");
		}
		
	}
}
