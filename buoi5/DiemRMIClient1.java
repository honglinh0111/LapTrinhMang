import java.rmi.*;
import java.net.MalformedURLException;
public class DiemRMIClient1 {
	public static void main(String[] args) {
		try {
			//Tim doi tuong goi tu xa
			DiemRMI_Itf dta = (DiemRMI_Itf)Naming.lookup("rmi://127.0.0.1/DiemA");//sai ten: NotBoundException
			DiemRMI_Itf dtb = (DiemRMI_Itf)Naming.lookup("rmi://127.0.0.1/DiemB");
			DiemRMI_Itf dtc = (DiemRMI_Itf)Naming.lookup("rmi://127.0.0.1/DiemC");
			//Goi ham tren doi tuong goi tu xa
			dta.doiDiem(10, 20);
			dtb.ganToaDo(55, 66);
			dtc.ganToaDo(-1, 10);
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
