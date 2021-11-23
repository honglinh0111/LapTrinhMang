//Ho Ten: Pham Thi Hong Linh
//MSSV: B1809365

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TH2_BAI1_ClientTachTen {

	public static void main(String[] args) {
		
		try {
			
			Socket s = new Socket("localhost",2345);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			Scanner sc = new Scanner(is);
			PrintWriter pw = new PrintWriter(os);
			
			while(true) {// 1 client nhap nhieu lan
				Scanner kb = new Scanner(System.in);
				System.out.print("Nhap vao Ho ten: ");
				String hoten = kb.nextLine();
				
				pw.println(hoten); pw.flush();
				if(hoten.equals("EXIT")) break;
				
				String kq = sc.nextLine();
				System.out.println("Ten cua ban la: "+kq);
			}
			s.close();
			
		}
		catch(IOException e) {
			System.out.println("Khong khoi tao duoc Socket Client");
		}
		

	}

}
