import java.net.*;
import java.util.Scanner;
import java.io.*;

public class readclient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",2222);
			System.out.println("Da noi ket thanh cong den server");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			Scanner kb = new Scanner(System.in);
			System.out.print("Nhap ten file can luu tren Server: ");
			String tenfile = kb.nextLine();
			System.out.print("Nhap ten file luu o cuc bo: ");
			String tenfileluu = kb.nextLine();
			
			String caulenh = "READ "+tenfile;
			pw.println(caulenh); pw.flush();
			
			String n = sc.nextLine();
			int size = Integer.parseInt(n);
			
			if(size == -1 ) {
				System.out.println("File khong ton tai");
			}
			else
				if(size == 0) {
					System.out.println("File rong");
				}
				else {
					FileOutputStream fis = new FileOutputStream(tenfileluu);
					byte b[] = new byte[size];
					int tong=0;
					DataInputStream dis = new DataInputStream(is);
					while(true) {
						int k = dis.read(b, 0, size);
						fis.write(b,0,k);
						tong += k ;
						System.out.println("Da nhan duoc " + tong + " byte");
						if(tong==size) break;
					}
					fis.close();
					System.out.println("Luu file thanh cong");
				}
			s.close();
			
		}
		catch(UnknownHostException e) {
			System.out.println("Loi khong tim thay dia chi");
		}
		catch(IOException e) {
			System.out.println("Loi nhap xuat");
		}
	}

}
