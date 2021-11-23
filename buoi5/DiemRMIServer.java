import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class DiemRMIServer {
	public static void main(String[] args) {
		try {
			if(System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());
			//Tao doi tuong A, B, C cho phep goi tu xa ::: goi ham cuc bo
			DiemRMI a = new DiemRMI();
			DiemRMI b = new DiemRMI(7,9);
			DiemRMI c = new DiemRMI(20);
			System.out.println("Nhap gia tri cho diem A");
			a.nhap();
			System.out.println("Toa do cua cac diem");
			System.out.print("Diem A: "); a.hienThi(); System.out.println();
			System.out.print("Diem B: "); b.hienThi(); System.out.println();
			System.out.print("Diem C: "); c.hienThi(); System.out.println();
			//Dang ky dt A, B, C cho phep goi tu xa
			Naming.rebind("DiemA", a);
			Naming.rebind("DiemB", b);
			Naming.rebind("DiemC", c);
			System.out.println("Da dang ky 3 doi tuong goi tu xa A B C");
		}
		catch(RemoteException e) {
			System.out.println("Loi khi tao hoac dang ky doi tuong goi tu xa");
		}
		catch(MalformedURLException e) {
			System.out.println("Ten dang ky sai dinh dang URL");
		}
	}
}