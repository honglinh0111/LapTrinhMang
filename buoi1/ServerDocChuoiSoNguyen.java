//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ServerDocChuoiSoNguyen {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(555);
			System.out.println("Da khoi tao xong Server");
			
			while(true) { // phuc vu nhieu client
				try {
					Socket s = ss.accept();
					System.out.println("Co 1 Client dia chi "+s.getInetAddress()+" cong "+s.getPort()+" noi ket");
					
					InputStream is = s.getInputStream();
					OutputStream os = s.getOutputStream();
					while(true) {//phuc vu 1 client nhieu lan
						//Nhan dl tu client: mang byte
						byte b[] = new byte[100];
						int n = is.read(b); 
						String chuoi = new String(b,0,n);
						if(chuoi.equals("EXIT")) break;
						//Integer.parseInt(chuoi)
						//xu ly kqua nhan duoc
						//doi chuoi thanh so
						int so = Integer.valueOf(chuoi).intValue();
						//so chuyen qua nhi phan
						String kq = Integer.toBinaryString(so);
						
						System.out.println("Ket qua nhan duoc la: "+kq);
						
						os.write(kq.getBytes());
					}
					s.close();
				}
				catch(IOException e) {
					System.out.print("Khong cung cap duoc dich vu Socket Server");
				}
			}
			//ss.close();
		}
		catch(IOException e) {
			System.out.print("Khong tao duoc Socket Server");
		}
		catch(NumberFormatException e) {
			System.out.print("Loi : Nhan tu Clien phai la mot chuoi so nguyen");
		}
		
	}

}
