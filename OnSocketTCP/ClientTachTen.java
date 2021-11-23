import java.net.*;
import java.util.Scanner;
import java.io.*;
public class ClientTachTen {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",4777);
			System.out.println("Da noi ket den Server");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			while(true) {
				System.out.print("Nhap ho ten: ");
				Scanner kb = new Scanner(System.in);
				String hoten = kb.nextLine();
				
				pw.println(hoten); pw.flush();
				
				if(hoten.equals("EXIT")) break;
				
				String ten = sc.nextLine();
				System.out.println("Ten cua ban la: "+ten);
			}
			s.close();
			
		}
		catch(UnknownHostException e) {
			System.out.println("Khong tim thay dia chi Server");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
		

	}

}
