//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ClientDocChuoiSoNguyen {//Client nhap tu ban phim mot chuoi so nguyen

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",555);
			System.out.println("Da noi ket thanh cong den server");
			
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			
			while(true) { // 1 client nhap nhieu lan
				//Nhap mot chuoi so nguyen
				System.out.print("Nhap mot chuoi so nguyen: ");
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				
				//Gui dl qua server: mang byte
				os.write(str.getBytes());
				if(str.equals("EXIT")) break;
				
				//nhan dl tra ve tu server
				byte b[] = new byte[1000];
				int n = is.read(b); // so ky tu mang byte
				String kq = new String(b,0,n);
				System.out.println("Ket qua nhan duoc chuoi nhi phan la: "+kq);
			}
			s.close();
		}
		catch(UnknownHostException e) {
			System.out.print("Khong tim thay dia chi server de noi ket");
		}
		catch(IOException e) {
			System.out.print("Loi nhap xuat: Dau vao phai la mot chuoi so nguyen");
		}
		
	}
	
}
