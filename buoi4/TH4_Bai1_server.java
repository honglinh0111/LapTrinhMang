//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TH4_Bai1_server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8077);
			System.out.println("Da khoi tao thanh cong Web Server");
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			System.out.print("Nhan duoc tu client: ");
			while(true) {
				String kq = sc.nextLine();
				if(kq.equals("")) break;
				System.out.print(kq);
			}
			s.close();
		}
		catch(IOException e) {
			System.out.println("Loi: khong tao duoc Web Server");
		}
	}
}
