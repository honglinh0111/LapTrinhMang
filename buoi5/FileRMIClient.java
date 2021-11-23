//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.rmi.*;
import java.util.Scanner;
import java.io.*;

public class FileRMIClient {

	public static void main(String[] args) {
		try {
			//Tim doi tuong goi tu xa
			FileRMI_Itf dtf = (FileRMI_Itf)Naming.lookup("rmi://127.0.0.1/FileRMI");

			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file tren server can luu ve: ");
			String filename = kb.nextLine();
			System.out.print("Nhap ten file luu o cuc bo: ");
			String dowfilename = kb.nextLine();
			
			//Goi ham tren doi tuong goi tu xa
			int len = dtf.getLength(filename);			
			byte b[] = dtf.getFile(filename);
			FileOutputStream f = new FileOutputStream(dowfilename);
			DataOutputStream dos = new DataOutputStream(f);
			dos.write(b,0,len);
			System.out.println("Luu file thanh cong");
			
			f.close();
		}
		catch(RemoteException e) {
			System.out.println("Loi khi goi ham tu xa");
		}
		catch(NotBoundException e) {
			System.out.println("Khong tin thay doi tuong");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
