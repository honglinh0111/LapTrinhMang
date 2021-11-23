import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TH4_Bai1_server {
	public static void main(String[] args) {
		try {
			ServerSocket ss=new ServerSocket(8077);
			System.out.println("Da khoi tao thanh cong server socket");
			Socket s=ss.accept();
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			Scanner sc=new Scanner(is);
			System.out.print("Ket qua nhan duoc tu client: ");
			while(true) {
				int ch=is.read();
				if(ch==-1) break;
				System.out.print((char)ch);
			}
			s.close();
			ss.close();
		}
		catch(IOException e) {
			System.out.println("Loi: khong tao duoc server socket");
		}
	}
}
