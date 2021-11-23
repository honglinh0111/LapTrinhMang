import java.rmi.*;
import java.net.MalformedURLException;
public class DiemRMIClient {
	public static void main(String[] args) {
		try {
			//Tim doi tuong goi tu xa
			DiemRMI_Itf dta = (DiemRMI_Itf)Naming.lookup("rmi://127.0.0.1/DiemA");//sai ten: NotBoundException
			DiemRMI_Itf dtb = (DiemRMI_Itf)Naming.lookup("rmi://127.0.0.1/DiemB");
			DiemRMI_Itf dtc = (DiemRMI_Itf)Naming.lookup("rmi://127.0.0.1/DiemC");
			//Goi ham tren doi tuong goi tu xa
			System.out.println("Diem A: "+ dta.layToaDo());
			System.out.println("Diem B: "+ dtb.layToaDo());
			System.out.println("Diem C: "+ dtc.layToaDo());
//			
//			System.out.println("Doi diem A di 1 doan (1,2): ");
//			dta.doiDiem(1, 2);
//			System.out.println("Diem A sau khi doi: "+ dta.layToaDo());
//			
//			System.out.println("Gan toa do (6,6) cho diem B: ");
//			dtb.ganToaDo(6, 6);
//			System.out.println("Diem B sau khi gan: "+ dtb.layToaDo());
			
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
