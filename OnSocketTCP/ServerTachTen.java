import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ServerTachTen {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(4777);
			System.out.println("Da khoi tao thanh cong Socket Server");
			while(true) {
				Socket s = ss.accept();
				System.out.println("Da noi ket voi 1 client");
				
				InputStream is = s.getInputStream();
				OutputStream os = s.getOutputStream();
				Scanner sc = new Scanner(is);
				PrintWriter pw = new PrintWriter(os);
				while(true) {//client yc nhieu lan
					String hoten = sc.nextLine();
					if(hoten.equals("EXIT")) break;
					String t = hoten.trim();
					int m = t.lastIndexOf(' ');
					String ten = hoten.substring(m+1);
					
					pw.println(ten); pw.flush();
				}
				s.close();
			}
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}

	}

}
