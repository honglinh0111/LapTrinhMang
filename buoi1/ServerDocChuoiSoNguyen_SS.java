//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.util.Scanner;
import java.io.*;

class PhucVuNhiPhan extends Thread {
	Socket s;
	public PhucVuNhiPhan(Socket s1) {
		s = s1;
	}
	public void run() {
		try {
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true) {//phuc vu 1 client nhieu lan
				//Nhan dl tu client: mang byte
				byte b[] = new byte[100];
				int n = is.read(b); 
				String chuoi = new String(b,0,n);
				if(chuoi.equals("EXIT")) break;
				String kq = new String();
				try {
					//xu ly kqua nhan duoc
					//doi chuoi thanh so
					int so = Integer.valueOf(chuoi).intValue();
					//so chuyen qua nhi phan
					kq = Integer.toBinaryString(so);
					
					System.out.println("Ket qua nhan duoc la: "+kq);
				}
				catch(NumberFormatException e) {
					kq = "Khong phai la mot so nguyen";
				}
				os.write(kq.getBytes());
			}
			s.close();
			System.out.println("Dong ket noi 1 Client");
		}
		catch(IOException e) {
			System.out.println("Co loi khi phuc vu 1 Client");
		}
	}
}

class ServerDocChuoiSoNguyen_SS {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(555);
			System.out.println("Da khoi tao xong Server");
			
			while(true) { // phuc vu nhieu client
				try {
					Socket s = ss.accept();
					System.out.println("Co 1 Client noi ket");
					PhucVuNhiPhan pv2 = new PhucVuNhiPhan(s);
					pv2.start();
					
				}
				catch(IOException e) {
					System.out.print("Co loi khi ket noi 1 Client");
				}
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.print("Khong tao duoc Socket Server");
		}
		
	}

}
