import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {

	public static void main(String[] args) {
		try {
			// Tim doi tuong cho phep goi ham tu xa
			HelloInterface ref = (HelloInterface)Naming.lookup("rmi://127.0.0.1/ABC");
			// Goi ham tren doi tuong
			String ketqua = ref.sayHello();
			System.out.println("Ket qua nhan duoc la: "+ketqua);
		}
		catch(RemoteException e) {
			System.out.println("Loi khi tim doi tuong hoac goi ham tu xa");
		}
		catch(NotBoundException e) {
			System.out.println("Khong tim thay doi tuong ABC");
		}
		catch(MalformedURLException e) {
			System.out.println("Ten tim kiem sai dinh dang URL");
		}
	}

}
